// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class GlobalLineVariableDecl extends GlobalLineVarDecl {

    private String I1;
    private ArrayOperator ArrayOperator;
    private GlobalLineVarDecl GlobalLineVarDecl;

    public GlobalLineVariableDecl (String I1, ArrayOperator ArrayOperator, GlobalLineVarDecl GlobalLineVarDecl) {
        this.I1=I1;
        this.ArrayOperator=ArrayOperator;
        if(ArrayOperator!=null) ArrayOperator.setParent(this);
        this.GlobalLineVarDecl=GlobalLineVarDecl;
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ArrayOperator getArrayOperator() {
        return ArrayOperator;
    }

    public void setArrayOperator(ArrayOperator ArrayOperator) {
        this.ArrayOperator=ArrayOperator;
    }

    public GlobalLineVarDecl getGlobalLineVarDecl() {
        return GlobalLineVarDecl;
    }

    public void setGlobalLineVarDecl(GlobalLineVarDecl GlobalLineVarDecl) {
        this.GlobalLineVarDecl=GlobalLineVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayOperator!=null) ArrayOperator.accept(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayOperator!=null) ArrayOperator.traverseTopDown(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayOperator!=null) ArrayOperator.traverseBottomUp(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalLineVariableDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ArrayOperator!=null)
            buffer.append(ArrayOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalLineVarDecl!=null)
            buffer.append(GlobalLineVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalLineVariableDecl]");
        return buffer.toString();
    }
}
