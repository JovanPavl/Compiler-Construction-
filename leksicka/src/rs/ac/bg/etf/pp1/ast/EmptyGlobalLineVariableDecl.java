// generated with ast extension for cup
// version 0.8
// 21/7/2022 1:34:56


package rs.ac.bg.etf.pp1.ast;

public class EmptyGlobalLineVariableDecl extends GlobalLineVarDecl {

    public EmptyGlobalLineVariableDecl () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyGlobalLineVariableDecl(\n");

        buffer.append(tab);
        buffer.append(") [EmptyGlobalLineVariableDecl]");
        return buffer.toString();
    }
}
