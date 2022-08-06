// generated with ast extension for cup
// version 0.8
// 5/7/2022 22:26:46


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFullExpresion extends Designator {

    private String designatorName;
    private MultipleDesignator MultipleDesignator;

    public DesignatorFullExpresion (String designatorName, MultipleDesignator MultipleDesignator) {
        this.designatorName=designatorName;
        this.MultipleDesignator=MultipleDesignator;
        if(MultipleDesignator!=null) MultipleDesignator.setParent(this);
    }

    public String getDesignatorName() {
        return designatorName;
    }

    public void setDesignatorName(String designatorName) {
        this.designatorName=designatorName;
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

        buffer.append(" "+tab+designatorName);
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
