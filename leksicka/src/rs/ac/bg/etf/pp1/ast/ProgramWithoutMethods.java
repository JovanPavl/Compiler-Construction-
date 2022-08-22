// generated with ast extension for cup
// version 0.8
// 22/7/2022 13:18:30


package rs.ac.bg.etf.pp1.ast;

public class ProgramWithoutMethods extends Program {

    private ProgName ProgName;
    private Mdecl Mdecl;

    public ProgramWithoutMethods (ProgName ProgName, Mdecl Mdecl) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.Mdecl=Mdecl;
        if(Mdecl!=null) Mdecl.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
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
        if(ProgName!=null) ProgName.accept(visitor);
        if(Mdecl!=null) Mdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(Mdecl!=null) Mdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(Mdecl!=null) Mdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramWithoutMethods(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
