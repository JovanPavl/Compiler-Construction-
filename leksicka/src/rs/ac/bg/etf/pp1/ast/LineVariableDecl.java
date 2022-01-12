// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class LineVariableDecl extends LineVarDecl {

    private ArrayOperator ArrayOperator;
    private LineVarDecl LineVarDecl;

    public LineVariableDecl (ArrayOperator ArrayOperator, LineVarDecl LineVarDecl) {
        this.ArrayOperator=ArrayOperator;
        if(ArrayOperator!=null) ArrayOperator.setParent(this);
        this.LineVarDecl=LineVarDecl;
        if(LineVarDecl!=null) LineVarDecl.setParent(this);
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
