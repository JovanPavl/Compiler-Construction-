// generated with ast extension for cup
// version 0.8
// 16/4/2022 8:55:50


package rs.ac.bg.etf.pp1.ast;

public class GlobalVariableDecl extends GlobalVarDecl {

    private SingleVarDecl SingleVarDecl;
    private GlobalLineVarDecl GlobalLineVarDecl;

    public GlobalVariableDecl (SingleVarDecl SingleVarDecl, GlobalLineVarDecl GlobalLineVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
        if(SingleVarDecl!=null) SingleVarDecl.setParent(this);
        this.GlobalLineVarDecl=GlobalLineVarDecl;
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.setParent(this);
    }

    public SingleVarDecl getSingleVarDecl() {
        return SingleVarDecl;
    }

    public void setSingleVarDecl(SingleVarDecl SingleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
    }

    public GlobalLineVarDecl getGlobalLineVarDecl() {
        return GlobalLineVarDecl;
    }

    public void setGlobalLineVarDecl(GlobalLineVarDecl GlobalLineVarDecl) {
        this.GlobalLineVarDecl=GlobalLineVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.accept(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseTopDown(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.traverseBottomUp(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVariableDecl(\n");

        if(SingleVarDecl!=null)
            buffer.append(SingleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalLineVarDecl!=null)
            buffer.append(GlobalLineVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVariableDecl]");
        return buffer.toString();
    }
}
