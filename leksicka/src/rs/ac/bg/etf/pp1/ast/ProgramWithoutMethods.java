// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class ProgramWithoutMethods extends Program {

    private Mdecl Mdecl;

    public ProgramWithoutMethods (Mdecl Mdecl) {
        this.Mdecl=Mdecl;
        if(Mdecl!=null) Mdecl.setParent(this);
    }

    public Mdecl getMdecl() {
        return Mdecl;
    }

    public void setMdecl(Mdecl Mdecl) {
        this.Mdecl=Mdecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Mdecl!=null) Mdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Mdecl!=null) Mdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Mdecl!=null) Mdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramWithoutMethods(\n");

        if(Mdecl!=null)
            buffer.append(Mdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramWithoutMethods]");
        return buffer.toString();
    }
}
