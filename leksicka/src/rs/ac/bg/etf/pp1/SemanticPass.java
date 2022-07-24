package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


//Tab.init
public class SemanticPass extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());

	int numberOfVariables, tmpValue;
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
		Struct varType = currType;
		String infoArr = "array ";
		
		if(arr instanceof EmptyArrayOperator) {
			varType = new Struct(Struct.Array, currType);
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

	public void visit(DesignatorFullExpresion designatorFullExpresion) {

	}

	public boolean passed() {
		return !errorDetected;
	}
}
