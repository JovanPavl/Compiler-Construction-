// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStat extends DesignatorStatement {

    private Designator Designator;
    private DesignatorPostOperation DesignatorPostOperation;

    public DesignatorStat (Designator Designator, DesignatorPostOperation DesignatorPostOperation) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorPostOperation=DesignatorPostOperation;
        if(DesignatorPostOperation!=null) DesignatorPostOperation.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorPostOperation getDesignatorPostOperation() {
        return DesignatorPostOperation;
    }

    public void setDesignatorPostOperation(DesignatorPostOperation DesignatorPostOperation) {
        this.DesignatorPostOperation=DesignatorPostOperation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorPostOperation!=null) DesignatorPostOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorPostOperation!=null) DesignatorPostOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorPostOperation!=null) DesignatorPostOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStat(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorPostOperation!=null)
            buffer.append(DesignatorPostOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStat]");
        return buffer.toString();
    }
}
