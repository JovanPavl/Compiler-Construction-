// generated with ast extension for cup
// version 0.8
// 24/6/2022 18:49:22


package rs.ac.bg.etf.pp1.ast;

public class OneMethodDeclaration extends ClassMethodDecl {

    private SingleMethodDecl SingleMethodDecl;

    public OneMethodDeclaration (SingleMethodDecl SingleMethodDecl) {
        this.SingleMethodDecl=SingleMethodDecl;
        if(SingleMethodDecl!=null) SingleMethodDecl.setParent(this);
    }

    public SingleMethodDecl getSingleMethodDecl() {
        return SingleMethodDecl;
    }

    public void setSingleMethodDecl(SingleMethodDecl SingleMethodDecl) {
        this.SingleMethodDecl=SingleMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleMethodDecl!=null) SingleMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleMethodDecl!=null) SingleMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleMethodDecl!=null) SingleMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneMethodDeclaration(\n");

        if(SingleMethodDecl!=null)
            buffer.append(SingleMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneMethodDeclaration]");
        return buffer.toString();
    }
}
