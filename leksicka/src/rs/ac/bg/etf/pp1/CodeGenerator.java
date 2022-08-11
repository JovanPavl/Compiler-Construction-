package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
	
	private int mainPc, tmpCnt = 0;
	private Obj currentMethod;
	private int debug = 0;
	
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
	
	public void visit(DesignatorFullExpresion designatorFullExpresion) {
		//TODO solve bug when left side of assigment is obj, no need to set it on stack
		//correct inc and dec then 
		MultipleDesignator multiDes = designatorFullExpresion.getMultipleDesignator();
		
		//here index goes before address so need to pop it and push it back
		if(multiDes instanceof DesignatorArray) {
			Code.load(designatorFullExpresion.obj);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
		}else {
			Code.load(designatorFullExpresion.obj);
		}
	}
	
	public void visit(DesignatorStat designatorStat) {
		Designator tmpDesignator = designatorStat.getDesignator();
		DesignatorPostOperation tmpdPostOp = designatorStat.getDesignatorPostOperation();
		
		if(tmpdPostOp instanceof AssignDesignatorOp) {
			//constant should already be on the stack
			Code.store(tmpDesignator.obj);
		}
		
		if(tmpdPostOp instanceof DesignatorIncrement) {
			Code.loadConst(1);	//designator should already be on the stack
			Code.put(Code.add);
			Code.store(tmpDesignator.obj);
		}
		
		if(tmpdPostOp instanceof DesignatorDecrement) {
			Code.loadConst(1);	//designator should already be on the stack
			Code.put(Code.sub);
			Code.store(tmpDesignator.obj);
		}
	}
	
	public void visit(GlobalVariableDecl globalVariableDecl) {
		Code.dataSize++;				//increase number of global variables
	}
	
	public void visit(MultipleAddExpr multipleAddExpr) {
		if(multipleAddExpr.getAddop() instanceof PlusOp) {
			Code.put(Code.add);
		}else {
			Code.put(Code.sub);
		}
	}
	
	public void visit(MultipleTerm multipleTerm) {
		Mulop mop = multipleTerm.getMulop();
		
		if(mop instanceof MulOperation) {
			Code.put(Code.mul);
		}
		
		if(mop instanceof DivOperation) {
			Code.put(Code.div);
		}
		
		if(mop instanceof ModulOperation) {
			Code.put(Code.rem);
		}
	}
	
	public void visit(MinusExpr minusExpr) {
		Code.put(Code.neg);
	}
	
	public void visit(NewTypeArray newTypeArray) {
		Type arrType = newTypeArray.getType();
		
		Code.put(Code.newarray);						//hopefully address is also pushed to the stack 
		
		if(arrType.struct.getKind() == Struct.Int) {
			Code.put(1);
		}else {
			Code.put(0);
		}
	}
}
