// generated with ast extension for cup
// version 0.8
// 10/7/2022 0:29:1


package rs.ac.bg.etf.pp1.ast;

public class RecordDeclaration extends Mdecl {

    private Mdecl Mdecl;
    private RecordStructure RecordStructure;

    public RecordDeclaration (Mdecl Mdecl, RecordStructure RecordStructure) {
        this.Mdecl=Mdecl;
        if(Mdecl!=null) Mdecl.setParent(this);
        this.RecordStructure=RecordStructure;
        if(RecordStructure!=null) RecordStructure.setParent(this);
    }

    public Mdecl getMdecl() {
        return Mdecl;
    }

    public void setMdecl(Mdecl Mdecl) {
        this.Mdecl=Mdecl;
    }

    public RecordStructure getRecordStructure() {
        return RecordStructure;
    }

    public void setRecordStructure(RecordStructure RecordStructure) {
        this.RecordStructure=RecordStructure;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Mdecl!=null) Mdecl.accept(visitor);
        if(RecordStructure!=null) RecordStructure.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Mdecl!=null) Mdecl.traverseTopDown(visitor);
        if(RecordStructure!=null) RecordStructure.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Mdecl!=null) Mdecl.traverseBottomUp(visitor);
        if(RecordStructure!=null) RecordStructure.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclaration(\n");

        if(Mdecl!=null)
            buffer.append(Mdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecordStructure!=null)
            buffer.append(RecordStructure.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDeclaration]");
        return buffer.toString();
    }
}
