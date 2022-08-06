// generated with ast extension for cup
// version 0.8
// 6/7/2022 13:57:53


package rs.ac.bg.etf.pp1.ast;

public class ProgramWithMethods extends Program {

    private ProgName ProgName;
    private Mdecl Mdecl;
    private ClassMethodDecl ClassMethodDecl;

    public ProgramWithMethods (ProgName ProgName, Mdecl Mdecl, ClassMethodDecl ClassMethodDecl) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.Mdecl=Mdecl;
        if(Mdecl!=null) Mdecl.setParent(this);
        this.ClassMethodDecl=ClassMethodDecl;
        if(ClassMethodDecl!=null) ClassMethodDecl.setParent(this);
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

    public ClassMethodDecl getClassMethodDecl() {
        return ClassMethodDecl;
    }

    public void setClassMethodDecl(ClassMethodDecl ClassMethodDecl) {
        this.ClassMethodDecl=ClassMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(Mdecl!=null) Mdecl.accept(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(Mdecl!=null) Mdecl.traverseTopDown(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(Mdecl!=null) Mdecl.traverseBottomUp(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramWithMethods(\n");

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

        if(ClassMethodDecl!=null)
            buffer.append(ClassMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramWithMethods]");
        return buffer.toString();
    }
}
