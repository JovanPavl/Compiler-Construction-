// generated with ast extension for cup
// version 0.8
// 19/5/2022 17:40:43


package rs.ac.bg.etf.pp1.ast;

public class MultipleFormalParameters extends MultipleFormParams {

    private MultipleFormParams MultipleFormParams;
    private SingleVarDecl SingleVarDecl;

    public MultipleFormalParameters (MultipleFormParams MultipleFormParams, SingleVarDecl SingleVarDecl) {
        this.MultipleFormParams=MultipleFormParams;
        if(MultipleFormParams!=null) MultipleFormParams.setParent(this);
        this.SingleVarDecl=SingleVarDecl;
        if(SingleVarDecl!=null) SingleVarDecl.setParent(this);
    }

    public MultipleFormParams getMultipleFormParams() {
        return MultipleFormParams;
    }

    public void setMultipleFormParams(MultipleFormParams MultipleFormParams) {
        this.MultipleFormParams=MultipleFormParams;
    }

    public SingleVarDecl getSingleVarDecl() {
        return SingleVarDecl;
    }

    public void setSingleVarDecl(SingleVarDecl SingleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.accept(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleFormParams!=null) MultipleFormParams.traverseTopDown(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.traverseBottomUp(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFormalParameters(\n");

        if(MultipleFormParams!=null)
            buffer.append(MultipleFormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleVarDecl!=null)
            buffer.append(SingleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFormalParameters]");
        return buffer.toString();
    }
}
