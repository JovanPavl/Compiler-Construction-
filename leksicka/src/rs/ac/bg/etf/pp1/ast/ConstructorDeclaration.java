// generated with ast extension for cup
// version 0.8
// 24/6/2022 18:49:22


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclaration extends ConstructorDecl {

    private String I1;
    private MultipleVarDecl MultipleVarDecl;
    private ListStatement ListStatement;

    public ConstructorDeclaration (String I1, MultipleVarDecl MultipleVarDecl, ListStatement ListStatement) {
        this.I1=I1;
        this.MultipleVarDecl=MultipleVarDecl;
        if(MultipleVarDecl!=null) MultipleVarDecl.setParent(this);
        this.ListStatement=ListStatement;
        if(ListStatement!=null) ListStatement.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MultipleVarDecl getMultipleVarDecl() {
        return MultipleVarDecl;
    }

    public void setMultipleVarDecl(MultipleVarDecl MultipleVarDecl) {
        this.MultipleVarDecl=MultipleVarDecl;
    }

    public ListStatement getListStatement() {
        return ListStatement;
    }

    public void setListStatement(ListStatement ListStatement) {
        this.ListStatement=ListStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleVarDecl!=null) MultipleVarDecl.accept(visitor);
        if(ListStatement!=null) ListStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseTopDown(visitor);
        if(ListStatement!=null) ListStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseBottomUp(visitor);
        if(ListStatement!=null) ListStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDeclaration(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MultipleVarDecl!=null)
            buffer.append(MultipleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListStatement!=null)
            buffer.append(ListStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclaration]");
        return buffer.toString();
    }
}
