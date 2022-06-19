// generated with ast extension for cup
// version 0.8
// 19/5/2022 17:40:43


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFullExpresion extends Designator {

    private String I1;
    private MultipleDesignator MultipleDesignator;

    public DesignatorFullExpresion (String I1, MultipleDesignator MultipleDesignator) {
        this.I1=I1;
        this.MultipleDesignator=MultipleDesignator;
        if(MultipleDesignator!=null) MultipleDesignator.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MultipleDesignator getMultipleDesignator() {
        return MultipleDesignator;
    }

    public void setMultipleDesignator(MultipleDesignator MultipleDesignator) {
        this.MultipleDesignator=MultipleDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleDesignator!=null) MultipleDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleDesignator!=null) MultipleDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleDesignator!=null) MultipleDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorFullExpresion(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MultipleDesignator!=null)
            buffer.append(MultipleDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorFullExpresion]");
        return buffer.toString();
    }
}
