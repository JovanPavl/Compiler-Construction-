package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
	
	private int mainPc, tmpCnt = 0;
	private Obj currentMethod;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(PrintStatement printStatement) {
		int kind = printStatement.getExpr().struct.getKind();
		
		int width = 1;
		
		if(kind == Struct.Int) {
			width = 5;
		}
		
		if(kind == Struct.Int) {
			Code.loadConst(width);
		}
		
		if(kind != Struct.Int) {
			Code.put(Code.bprint);
		}else {
			Code.put(Code.print);
		}
	}
	
	public void visit (SingleMethodName singleMethodName) {
		singleMethodName.obj.setAdr(Code.pc);
		
		currentMethod = Tab.find(singleMethodName.getMethodName());
		
		Code.put(Code.enter);
		Code.put(0);			//didn't work with formal parameters 
		Code.put(singleMethodName.obj.getLocalSymbols().size());
	}
	
	public void visit(SingleMethodDeclaration singleMethodDeclaration) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(CharConst charConst) {
		Code.loadConst(charConst.getC1());
	}
	
	public void visit(NumConst numConst) {
		Code.loadConst(numConst.getN1());
	}
	
	public void visit(BoolConst boolConst) {
		Code.loadConst(boolConst.getB1());
	}
	
/*	public void visit(SimpleConstDecl simpleConstDecl) {
		Obj globalVar = TabE.find(simpleConstDecl.getVarName());
		globalVar.setAdr(tmpCnt++);
		globalVar.setLevel(0);
		//posto je iz nekog razloga glup moram rucno :) 
		
		Code.dataSize++;
		Consts constValue = simpleConstDecl.getConsts();
		
		if(constValue instanceof NumberConstant) {
			Code.loadConst(((NumberConstant)constValue).getValue());
		}
		
		if(constValue instanceof BooleanConstant) {
			Code.loadConst(((BooleanConstant)constValue).getValue());
		}
		
		if(constValue instanceof CharacterConstant) {
			Code.loadConst(((CharacterConstant)constValue).getValue());
		}
		
		Code.store(globalVar);
	}*/
	
	public void visit(DesignatorFullExpresion designatorFullExpresion) {
		Code.load(designatorFullExpresion.obj);
	}
	
	public void visit(DesignatorStat designatorStat) {
		Designator tmpDesignator = designatorStat.getDesignator();
		DesignatorPostOperation tmpdPostOp = designatorStat.getDesignatorPostOperation();
		
		if(tmpdPostOp instanceof AssignDesignatorOp) {
			//constant should already be on the stack
			Code.store(tmpDesignator.obj);
		}
	}
}
