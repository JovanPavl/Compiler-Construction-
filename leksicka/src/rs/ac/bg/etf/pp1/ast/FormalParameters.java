// generated with ast extension for cup
// version 0.8
// 24/6/2022 18:49:22


package rs.ac.bg.etf.pp1.ast;

public class FormalParameters extends FormParams {

    private MultipleFormParams MultipleFormParams;

    public FormalParameters (MultipleFormParams MultipleFormParams) {
        this.MultipleFormParams=MultipleFormParams;
        if(MultipleFormParams!=null) MultipleFormParams.setParent(this);
    }

    public MultipleFormParams getMultipleFormParams() {
        return MultipleFormParams;
    }

    public void setMultipleFormParams(MultipleFormParams MultipleFormParams) {
        this.MultipleFormParams=MultipleFormParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleFormParams!=null) MultipleFormParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParameters(\n");

        if(MultipleFormParams!=null)
            buffer.append(MultipleFormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParameters]");
        return buffer.toString();
    }
}
