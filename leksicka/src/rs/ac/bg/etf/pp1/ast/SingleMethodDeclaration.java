// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class SingleMethodDeclaration extends SingleMethodDecl {

    private SingleMethodName SingleMethodName;
    private FormParams FormParams;
    private MultipleVarDecl MultipleVarDecl;
    private ListStatement ListStatement;

    public SingleMethodDeclaration (SingleMethodName SingleMethodName, FormParams FormParams, MultipleVarDecl MultipleVarDecl, ListStatement ListStatement) {
        this.SingleMethodName=SingleMethodName;
        if(SingleMethodName!=null) SingleMethodName.setParent(this);
        this.FormParams=FormParams;
        if(FormParams!=null) FormParams.setParent(this);
        this.MultipleVarDecl=MultipleVarDecl;
        if(MultipleVarDecl!=null) MultipleVarDecl.setParent(this);
        this.ListStatement=ListStatement;
        if(ListStatement!=null) ListStatement.setParent(this);
    }

    public SingleMethodName getSingleMethodName() {
        return SingleMethodName;
    }

    public void setSingleMethodName(SingleMethodName SingleMethodName) {
        this.SingleMethodName=SingleMethodName;
    }

    public FormParams getFormParams() {
        return FormParams;
    }

    public void setFormParams(FormParams FormParams) {
        this.FormParams=FormParams;
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
        if(SingleMethodName!=null) SingleMethodName.accept(visitor);
        if(FormParams!=null) FormParams.accept(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.accept(visitor);
        if(ListStatement!=null) ListStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleMethodName!=null) SingleMethodName.traverseTopDown(visitor);
        if(FormParams!=null) FormParams.traverseTopDown(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseTopDown(visitor);
        if(ListStatement!=null) ListStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleMethodName!=null) SingleMethodName.traverseBottomUp(visitor);
        if(FormParams!=null) FormParams.traverseBottomUp(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseBottomUp(visitor);
        if(ListStatement!=null) ListStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleMethodDeclaration(\n");

        if(SingleMethodName!=null)
            buffer.append(SingleMethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParams!=null)
            buffer.append(FormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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
        buffer.append(") [SingleMethodDeclaration]");
        return buffer.toString();
    }
}
