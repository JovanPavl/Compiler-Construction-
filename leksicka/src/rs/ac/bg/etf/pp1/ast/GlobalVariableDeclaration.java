// generated with ast extension for cup
// version 0.8
// 24/6/2022 18:49:22


package rs.ac.bg.etf.pp1.ast;

public class GlobalVariableDeclaration extends Mdecl {

    private Mdecl Mdecl;
    private GlobalVarDecl GlobalVarDecl;

    public GlobalVariableDeclaration (Mdecl Mdecl, GlobalVarDecl GlobalVarDecl) {
        this.Mdecl=Mdecl;
        if(Mdecl!=null) Mdecl.setParent(this);
        this.GlobalVarDecl=GlobalVarDecl;
        if(GlobalVarDecl!=null) GlobalVarDecl.setParent(this);
    }

    public Mdecl getMdecl() {
        return Mdecl;
    }

    public void setMdecl(Mdecl Mdecl) {
        this.Mdecl=Mdecl;
    }

    public GlobalVarDecl getGlobalVarDecl() {
        return GlobalVarDecl;
    }

    public void setGlobalVarDecl(GlobalVarDecl GlobalVarDecl) {
        this.GlobalVarDecl=GlobalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Mdecl!=null) Mdecl.accept(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Mdecl!=null) Mdecl.traverseTopDown(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Mdecl!=null) Mdecl.traverseBottomUp(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVariableDeclaration(\n");

        if(Mdecl!=null)
            buffer.append(Mdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDecl!=null)
            buffer.append(GlobalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVariableDeclaration]");
        return buffer.toString();
    }
}
