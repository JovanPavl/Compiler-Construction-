// generated with ast extension for cup
// version 0.8
// 6/7/2022 17:26:45


package rs.ac.bg.etf.pp1.ast;

public class EmptyClassAllMethodDeclaration extends ClassAllMethodDecl {

    public EmptyClassAllMethodDeclaration () {
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
        buffer.append("EmptyClassAllMethodDeclaration(\n");

        buffer.append(tab);
        buffer.append(") [EmptyClassAllMethodDeclaration]");
        return buffer.toString();
    }
}
