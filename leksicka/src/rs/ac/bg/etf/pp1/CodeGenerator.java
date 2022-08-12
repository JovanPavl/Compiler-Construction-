package rs.ac.bg.etf.pp1;

import java.util.HashMap;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
	
	private int mainPc, tmpCnt = 0;
	private Obj currentMethod;
	private int debug = 0;
	HashMap<String, Obj> assignedObjs = new HashMap<String, Obj>();
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(PrintStatement printStatement) {
		int kind = printStatement.getExpr().struct.getKind();
		
		int width = 1;
		
		if(kind == Struct.Int) {
			width = 5;
		}

		Code.loadConst(width);
		
		if(kind != Struct.Int) {
			Code.put(Code.bprint);
		}else {
			Code.put(Code.print);
		}
	}
	
	public void visit(ReadStatement readStatement) {
		//if it's array we are fine, but if it's read statement no need to load designator
		Designator tmpDesignator = readStatement.getDesignator();
		Code.put(Code.read);
		Code.store(tmpDesignator.obj);
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
		SyntaxNode parent = designatorFullExpresion.getParent();
		MultipleDesignator multiDes = designatorFullExpresion.getMultipleDesignator();
		
		if(multiDes instanceof DesignatorArray) {
			Code.load(assignedObjs.get(designatorFullExpresion.getDesignatorName()));
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
		}
		
		if(parent instanceof ReadStatement) {
			return ;
		}
		
		if(parent instanceof DesignatorStat) {
			if(((DesignatorStat)parent).getDesignatorPostOperation() instanceof AssignDesignatorOp) {
				//if designator is on left side of equal operation no need to put it on stack 
				//but if it's an array we need address, we also need address if operator is on rightside
				return ;
			}
		}
		
		Code.load(designatorFullExpresion.obj);
	}
	
	public void visit(DesignatorStat designatorStat) {
		Designator tmpDesignator = designatorStat.getDesignator();
		DesignatorPostOperation tmpdPostOp = designatorStat.getDesignatorPostOperation();
		
		if(tmpdPostOp instanceof AssignDesignatorOp) {
			if(assignedObjs.get(tmpDesignator.obj.getName()) == null)
				assignedObjs.put(tmpDesignator.obj.getName(), tmpDesignator.obj);
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
