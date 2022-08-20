// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class ErrorVarDecl extends GlobalVarDecl {

    private GlobalLineVarDecl GlobalLineVarDecl;

    public ErrorVarDecl (GlobalLineVarDecl GlobalLineVarDecl) {
        this.GlobalLineVarDecl=GlobalLineVarDecl;
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.setParent(this);
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
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalLineVarDecl!=null) GlobalLineVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorVarDecl(\n");

        if(GlobalLineVarDecl!=null)
            buffer.append(GlobalLineVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrorVarDecl]");
        return buffer.toString();
    }
}
