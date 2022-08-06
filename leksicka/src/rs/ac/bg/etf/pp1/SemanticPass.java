package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


//Tab.init
public class SemanticPass extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());

	int numberOfVariables, tmpValue, ask_method = 0;
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
		newConst.setAdr(tmpValue);
		
		report_info("Constant: " + simpleConstDecl.getVarName() + " with value " + tmpValue + " declared", simpleConstDecl);
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
		
		report_info("Variable: " + singleVariableDecl.getVarName() + " with type " + infoArr + " " + currType.getKind() + " declared", singleVariableDecl);
		
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
		
		currMethod = TabE.insert(Obj.Meth, singleMethodName.getMethodName(), retType);
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
		newTypeArray.struct = new Struct(Struct.Array, new Struct(Struct.Int));
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
	
	public boolean passed() {
		return !errorDetected;
	}
}
