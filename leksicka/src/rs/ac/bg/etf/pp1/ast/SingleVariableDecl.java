// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class SingleVariableDecl extends SingleVarDecl {

    private Type Type;
    private ArrayOperator ArrayOperator;

    public SingleVariableDecl (Type Type, ArrayOperator ArrayOperator) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrayOperator=ArrayOperator;
        if(ArrayOperator!=null) ArrayOperator.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ArrayOperator getArrayOperator() {
        return ArrayOperator;
    }

    public void setArrayOperator(ArrayOperator ArrayOperator) {
        this.ArrayOperator=ArrayOperator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ArrayOperator!=null) ArrayOperator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayOperator!=null) ArrayOperator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayOperator!=null) ArrayOperator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVariableDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayOperator!=null)
            buffer.append(ArrayOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVariableDecl]");
        return buffer.toString();
    }
}
