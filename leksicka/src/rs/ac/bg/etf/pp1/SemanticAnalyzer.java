package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


//Tab.init
public class SemanticAnalyzer extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());

	int numberOfVariables, tmpValue, ask_method = 0,  while_depth = 0, global_adr = 0;
	Obj currMethod = null;
	Struct currType = null;
	
	public boolean errorDetected = false;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line ").append(line);
		log.info(msg.toString());
	}
	
	public boolean checkCompatibility(Struct lside, Struct rside) {
		if(lside.getKind() == Struct.Array) {
			if(rside.equals(TabE.find("null").getType())) {
				return true;
			}
			if(rside.getKind() == Struct.Array) {
				return rside.getElemType().getKind() == lside.getElemType().getKind();
			}
			return false;
		}
		
		//if there are no arrays, check same type
		return rside.getKind() == lside.getKind();
	}

	public void visit(ProgName progName) {
		progName.obj = TabE.insert(Obj.Prog, progName.getProgName(), TabE.noType);
		TabE.openScope();
	}

	public void visit(ProgramWithoutMethods programWithoutMethods) {
		numberOfVariables = TabE.currentScope.getnVars();
		TabE.chainLocalSymbols(programWithoutMethods.getProgName().obj);
		TabE.closeScope();
		report_info("programWithoutMethods", programWithoutMethods);
	}

	public void visit(ProgramWithMethods programWithMethods) {
		numberOfVariables = TabE.currentScope.getnVars();
		TabE.chainLocalSymbols(programWithMethods.getProgName().obj);
		Obj mainMethod = TabE.find("main");
		if (mainMethod == TabE.noObj || mainMethod.getKind() != Obj.Meth || mainMethod.getType() != TabE.noType && mainMethod.getLevel() != 0)
			report_error("main has wrong type or doesn't exist !", programWithMethods);
		TabE.closeScope();
		report_info("programWithMethods", programWithMethods);
	}

	public void visit(Type type) {
		Obj typeObj = TabE.find(type.getTypeName());
		if (typeObj == TabE.noObj) {
			type.struct = TabE.noType;
			report_error("Error: " + type.getTypeName() + " is not found in table of symbols", null);
		} else {
			if (Obj.Type == typeObj.getKind()) {
				type.struct = typeObj.getType();
			} else {
				type.struct = TabE.noType;
				report_error("Error: " + type.getTypeName() + " is not type", type);
			}
		}
		currType = type.struct;
	}
	
	public void visit(SimpleConstDecl simpleConstDecl) {
		if(TabE.currentScope.findSymbol(simpleConstDecl.getVarName()) != null) {
			report_error("Error: " + simpleConstDecl.getVarName() + " is defined before", simpleConstDecl);
			return;
		}
		if(currType == null) {
			report_error("Error: " + simpleConstDecl.getVarName() + "has no type", simpleConstDecl);
			return;
		}
		Consts constValue = simpleConstDecl.getConsts();

		if(constValue instanceof NumberConstant) {
			if(currType.getKind() == Struct.Int) {
				tmpValue = ((NumberConstant)constValue).getValue();
			}else {
				report_error("Error: " + simpleConstDecl.getVarName() + "has bad type", simpleConstDecl);
			}
		}
		
		if(constValue instanceof BooleanConstant) {
			if(currType.getKind() == Struct.Bool) {
				tmpValue = ((BooleanConstant)constValue).getValue();
			}else {
				report_error("Error: " + simpleConstDecl.getVarName() + "has bad type", simpleConstDecl);
			}
		}
		
		if(constValue instanceof CharacterConstant) {
			if(currType.getKind() == Struct.Char) {
				tmpValue = ((CharacterConstant)constValue).getValue();
			}else {
				report_error("Error: " + simpleConstDecl.getVarName() + "has bad type", simpleConstDecl);
			}
		}
		Obj newConst = TabE.insert(Obj.Con, simpleConstDecl.getVarName(), currType);
		
		newConst.setLevel(0);			
		
		newConst.setAdr(tmpValue);				//maybe will be changed
		
		report_info("Constant: " + simpleConstDecl.getVarName() + " with value " + tmpValue + " declared", simpleConstDecl);
		
		Obj use = TabE.find(simpleConstDecl.getVarName());
	}

	public void visit(SingleVariableDecl singleVariableDecl) {
		if(TabE.currentScope.findSymbol(singleVariableDecl.getVarName()) != null) {
			report_error("Error: " + singleVariableDecl.getVarName() + " is defined before", singleVariableDecl);
			return;
		}
		if(currType == null) {
			report_error("Error: " + singleVariableDecl.getVarName() + "has no type", singleVariableDecl);
			return;
		}
		
		ArrayOperator arr = singleVariableDecl.getArrayOperator();
		Struct varType = new Struct(Struct.Array, currType);
		String infoArr = "array ";
		
		if(arr instanceof EmptyArrayOperator) {
			varType = currType;
			infoArr = "";
		}
		
		//TODO:need to find out if it's declared inside method, class field or global
		//for now only global will be used
		int objType = Obj.Var;
		
		TabE.insert(objType, singleVariableDecl.getVarName(), varType);
		
		report_info("Variable: " + singleVariableDecl.getVarName() + " with type " + infoArr + " " + currType.getKind() + " declared " , singleVariableDecl);
		
	}
	public void visit(GlobalVariableDecl globalVariableDecl) {
		
	}

	public void visit(DesignatorArray designatorArray) {

	}
	
	public void visit(SingleMethodDeclaration singleMethodDecleration) {
		singleMethodDecleration.obj = currMethod;
		TabE.chainLocalSymbols(currMethod);
		TabE.closeScope();
		currMethod = null;
		ask_method = 0;
	}
	public void visit(SingleMethodName singleMethodName) {
		if(TabE.currentScope.findSymbol(singleMethodName.getMethodName()) != null) {
			report_error("Error: " + singleMethodName.getMethodName() + " is defined before", singleMethodName);
			return;
		}
		
		Struct retType = null;
		MethodReturnType rtype = singleMethodName.getMethodReturnType();
		if(rtype instanceof VoidType) {
			retType = TabE.noType;
		}else {
			retType = ((ReturnType)rtype).getType().struct;
		}
		
		singleMethodName.obj = currMethod = TabE.insert(Obj.Meth, singleMethodName.getMethodName(), retType);
		//check if it's in the class?
		ask_method = 1;
		
		TabE.openScope();
		

		//something with code generation done here
		
		report_info("Method " + singleMethodName.getMethodName() + " with type " + retType.getKind(), singleMethodName);
		
	}

	public void visit(PrintStatement printStatement) {
		int tmp = printStatement.getExpr().struct.getKind();
		if(tmp == Struct.Bool || tmp == Struct.Int || tmp == Struct.Char)
			return ;
		report_error("Parameter of print statement is not char, bool or int", printStatement);
	}
	
	public void visit(MinusExpr minusExpr) {
		minusExpr.struct = minusExpr.getAddExpr().struct;
		if(minusExpr.struct.getKind() != Struct.Int) {
			report_error("Expression with minus sign must be type of int", minusExpr);
		}
	}
	
	public void visit(BinaryOperator binaryOperator) {
		binaryOperator.struct = binaryOperator.getExpr().struct;
		if(binaryOperator.struct.getKind() != Struct.Int) {
			report_error("Binary operator must be type of int", binaryOperator);
		}
	}
	
	public void visit(RestOfBinopMinusExpr restOfBinopMinusExpr) {
		restOfBinopMinusExpr.struct = restOfBinopMinusExpr.getAddExpr().struct;
		if(restOfBinopMinusExpr.struct.getKind() != Struct.Int) {
			report_error("Binary operator must be type of int", restOfBinopMinusExpr);
		}
	}
	
	public void visit(RestOfBinopAddExptOnly restOfBinopAddExptOnly) {
		restOfBinopAddExptOnly.struct = restOfBinopAddExptOnly.getAddExpr().struct;
	}
	public void visit(AddExptOnly addExptOnly) {
		addExptOnly.struct = addExptOnly.getAddExpr().struct;
	}
	
	public void visit(OneAddExpr oneAddExpr) {
		oneAddExpr.struct = oneAddExpr.getTerm().struct;
	}
	
	public void visit(MultipleAddExpr multipleAddExpr) {
		multipleAddExpr.struct = multipleAddExpr.getTerm().struct;
		if(multipleAddExpr.struct.getKind() != Struct.Int) {
			report_error("Expression with addop must be type of int", multipleAddExpr);
		}
	}
	
	public void visit(OneTerm oneTerm) {
		oneTerm.struct = oneTerm.getFactor().struct;
	}
	
	public void visit(MultipleTerm multipleTerm) {
		Term tmpTerm = multipleTerm.getTerm();
		if(tmpTerm.struct.getKind() != Struct.Int) {
			report_error("Term with mulop must be type of int", tmpTerm);
		}
		
		Factor factor = multipleTerm.getFactor();
		if(factor.struct.getKind() != Struct.Int) {
			report_error("Factor with mulop must be type of int", factor);
		}
		multipleTerm.struct = multipleTerm.getFactor().struct;
	}
	
	public void visit(CharConst charConst) {
		charConst.struct = new Struct(Struct.Char);
	}
	
	public void visit(BoolConst boolConst) {
		boolConst.struct = new Struct(Struct.Bool);
	}
	
	public void visit(NumConst numConst) {
		numConst.struct = new Struct(Struct.Int);
	}
	
	public void visit(ParenExpresion parenExpresion) {
		parenExpresion.struct = parenExpresion.getExpr().struct;
	}
	
	public void visit(DesignatorFactorExpresion designatorFactorExpresion) {
		designatorFactorExpresion.struct = designatorFactorExpresion.getDesignatorFactor().obj.getType();
	}
	
	public void visit(NewTypeFactorExpresion newTypeFactorExpresion) {
		newTypeFactorExpresion.struct = newTypeFactorExpresion.getNewTypeFactor().struct;
	}
	
	public void visit(NewTypeArray newTypeArray) {
		if(newTypeArray.getExpr().struct.getKind() != Struct.Int) {
			report_error("When creating new array expresion need to be type int", newTypeArray.getExpr());
		}
		newTypeArray.struct = new Struct(Struct.Array, newTypeArray.getType().struct);
	}
	
	public void visit(DesignatorOnly designatorOnly) {
		designatorOnly.obj = designatorOnly.getDesignator().obj;
	}

	
	public void visit (DesignatorFullExpresion designatorFullExpresion) {
		designatorFullExpresion.obj = TabE.find(designatorFullExpresion.getDesignatorName());
		if(designatorFullExpresion.obj.equals(TabE.noObj)) {
			report_error("Undeclared identifier " + designatorFullExpresion.getDesignatorName(), designatorFullExpresion);
			return ;
		}
		
		MultipleDesignator multipleDesignator = designatorFullExpresion.getMultipleDesignator();
		
		if(multipleDesignator instanceof DesignatorArray) {
			Expr expr = ((DesignatorArray)multipleDesignator).getExpr();
			if(expr.struct.getKind() != Struct.Int) {
				report_error("Expr that is array index should be type of int actual:" + expr.struct.getKind(), expr);
				return;
			}
			
			if(designatorFullExpresion.obj.getType().getKind() != Struct.Array) {
				report_error(designatorFullExpresion.getDesignatorName() + " is not array!", designatorFullExpresion);
				return;
			}
			
			designatorFullExpresion.obj = new Obj(Obj.Elem, designatorFullExpresion.getDesignatorName(), designatorFullExpresion.obj.getType().getElemType());
			
			report_info("Array operator used ", designatorFullExpresion);
		}
	}
	
	public void visit(DesignatorStat designatorStat) {
		Designator tmpDesignator = designatorStat.getDesignator();
		DesignatorPostOperation tmpdPostOp = designatorStat.getDesignatorPostOperation();
		
		if(tmpdPostOp instanceof AssignDesignatorOp) {
			if(tmpDesignator.obj.getKind() != Obj.Elem && tmpDesignator.obj.getKind() != Obj.Var) {
				report_error("Designator in assignop must be variable or element of array", designatorStat);
				return ;
			}
			if(!checkCompatibility(tmpDesignator.obj.getType(), ((AssignDesignatorOp) tmpdPostOp).getExpr().struct)) {
				report_error("Left and right side of assign operation are not compatible "
				, designatorStat);
				return ;
			}
		}
		
		if(tmpdPostOp instanceof DesignatorIncrement) {
			if(tmpDesignator.obj.getKind() != Obj.Elem && tmpDesignator.obj.getKind() != Obj.Var) {
				report_error("Designator in increment must be variable or element of array", designatorStat);
				return ;
			}
		}
		
		if(tmpdPostOp instanceof DesignatorDecrement) {
			if(tmpDesignator.obj.getKind() != Obj.Elem && tmpDesignator.obj.getKind() != Obj.Var) {
				report_error("Designator in decrement must be variable or element of array", designatorStat);
				return ;
			}
		}
	}
	
	public void visit(DoWhileHeader doWhileHeader) {
		while_depth++;
	}
	
	public void visit(DoWhileEnd doWhileEnd) {
		while_depth--;
	}
	
	public void visit(GotoStatement gotoStatement) {
		//not needed 
	}
	
	public void visit(BreakStatement breakStatement) {
		if(while_depth == 0) {
			report_error("Break statement is not in any while loop!", breakStatement);
			return ;
		}
	}
	
	public void visit(ContinueStatement contStatement) {
		if(while_depth == 0) {
			report_error("Continue statement is not in any while loop", contStatement);
			return ;
		}
	}
	
	public void visit(ReadStatement readStatement) {
		if(readStatement.getDesignator().obj.getKind() != Obj.Var && readStatement.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Parameter of read statement should be variable or array element!", readStatement);
			return ;
		}
		if(readStatement.getDesignator().obj.getType().getKind() != Struct.Int && 
				readStatement.getDesignator().obj.getType().getKind() != Struct.Char &&
				readStatement.getDesignator().obj.getType().getKind() != Struct.Bool) {
			report_error("Parameter of read statement should be type int, char or bool", readStatement);
		}
	}
	
	public void visit(ReturnStatementNoExpr returnStatementNoExpr) {
		if(ask_method == 0) {
			report_error("Return statement is not in method!", returnStatementNoExpr);
			return ;
		}
		
		if(currMethod.getType().getKind() != Struct.None) {
			report_error("Current method is not void and should return value", returnStatementNoExpr);
		}
	}
	
/*	public void visit(AssignDesignatorOp assignDesignatorOp) {
		if(ask_method == 0) {
			report_error("Return statement is not in method!", assignDesignatorOp);
			return ;
		}
		Expr exprTmp = assignDesignatorOp.getExpr();
		
		if(exprTmp.struct.getKind() != currMethod.getType().getKind()) {
			report_error("Return statement type is not same as method type! ", assignDesignatorOp);
			return ;
		}
	}*/
	
	public void visit(SingleIfCondition singleIfCondition) {
		singleIfCondition.struct = singleIfCondition.getCondTerm().struct;
		if(singleIfCondition.struct.getKind() != Struct.Bool) {
			report_error("Condition must be bool type!", singleIfCondition);
			return ;
		}
	}
	
	public void visit(MultipleIfCondition multipleIfCondition) {
		multipleIfCondition.struct = multipleIfCondition.getCondTerm().struct;
		if(multipleIfCondition.struct.getKind() != Struct.Bool) {
			report_error("Condition must be bool type!", multipleIfCondition);
			return ;
		}
	}
	
	public void visit(SingleCondTerm singleCondTerm) {
		singleCondTerm.struct = singleCondTerm.getCondFact().struct;
		if(singleCondTerm.struct.getKind() != Struct.Bool) {
			report_error("Condition Term must be bool type!", singleCondTerm);
			return ;
		}
	}
	
	public void visit(MultipleCondTerm multipleCondTerm) {
		multipleCondTerm.struct = multipleCondTerm.getCondFact().struct;
		if(multipleCondTerm.struct.getKind() != Struct.Bool){
			report_error("Condition term must be bool type!", multipleCondTerm);
			return ;
		}
	}
	
	public void visit(SingleCondFact singleCondFact) {
		singleCondFact.struct = singleCondFact.getExpr().struct;
		if(singleCondFact.struct.getKind() != Struct.Bool) {
			report_error("Condition factor must be bool type!", singleCondFact);
			return ;
		}
	}
	
	public void visit(MultipleCondFact multipleCondFact) {
		Expr expr = multipleCondFact.getExpr();
		Expr expr1 = multipleCondFact.getExpr1();
		Relop relop = multipleCondFact.getRelop();
		
		if(!this.checkCompatibility(expr.struct, expr1.struct)){
			report_error("Expresions don't have comatible type", multipleCondFact);
			return ;
		}
		
		if(expr.struct.getKind() == Struct.Array) {
			if(relop instanceof IsEqualOp || relop instanceof NotEqualOp) {
				return;
			}else {
				report_error("Arrays can be compared only using == and != operators", multipleCondFact);
				return ;
			}
		}
		
		
	}
	public boolean passed() {
		return !errorDetected;
	}
}
