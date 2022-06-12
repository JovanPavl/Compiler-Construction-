// generated with ast extension for cup
// version 0.8
// 16/4/2022 8:55:50


package rs.ac.bg.etf.pp1.ast;

public class LineVariableDecl extends LineVarDecl {

    private String I1;
    private ArrayOperator ArrayOperator;
    private LineVarDecl LineVarDecl;

    public LineVariableDecl (String I1, ArrayOperator ArrayOperator, LineVarDecl LineVarDecl) {
        this.I1=I1;
        this.ArrayOperator=ArrayOperator;
        if(ArrayOperator!=null) ArrayOperator.setParent(this);
        this.LineVarDecl=LineVarDecl;
        if(LineVarDecl!=null) LineVarDecl.setParent(this);
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

    public LineVarDecl getLineVarDecl() {
        return LineVarDecl;
    }

    public void setLineVarDecl(LineVarDecl LineVarDecl) {
        this.LineVarDecl=LineVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayOperator!=null) ArrayOperator.accept(visitor);
        if(LineVarDecl!=null) LineVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayOperator!=null) ArrayOperator.traverseTopDown(visitor);
        if(LineVarDecl!=null) LineVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayOperator!=null) ArrayOperator.traverseBottomUp(visitor);
        if(LineVarDecl!=null) LineVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LineVariableDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ArrayOperator!=null)
            buffer.append(ArrayOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LineVarDecl!=null)
            buffer.append(LineVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LineVariableDecl]");
        return buffer.toString();
    }
}
