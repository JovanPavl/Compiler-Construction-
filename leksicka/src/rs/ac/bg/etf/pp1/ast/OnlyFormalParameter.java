// generated with ast extension for cup
// version 0.8
// 16/4/2022 8:55:50


package rs.ac.bg.etf.pp1.ast;

public class OnlyFormalParameter extends MultipleFormParams {

    private SingleVarDecl SingleVarDecl;

    public OnlyFormalParameter (SingleVarDecl SingleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
        if(SingleVarDecl!=null) SingleVarDecl.setParent(this);
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
        if(SingleVarDecl!=null) SingleVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OnlyFormalParameter(\n");

        if(SingleVarDecl!=null)
            buffer.append(SingleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OnlyFormalParameter]");
        return buffer.toString();
    }
}