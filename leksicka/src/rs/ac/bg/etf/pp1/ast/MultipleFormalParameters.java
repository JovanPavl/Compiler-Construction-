// generated with ast extension for cup
// version 0.8
// 6/7/2022 17:26:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleFormalParameters extends MultipleFormParams {

    private MultipleFormParams MultipleFormParams;
    private MethodSingleParemeter MethodSingleParemeter;

    public MultipleFormalParameters (MultipleFormParams MultipleFormParams, MethodSingleParemeter MethodSingleParemeter) {
        this.MultipleFormParams=MultipleFormParams;
        if(MultipleFormParams!=null) MultipleFormParams.setParent(this);
        this.MethodSingleParemeter=MethodSingleParemeter;
        if(MethodSingleParemeter!=null) MethodSingleParemeter.setParent(this);
    }

    public MultipleFormParams getMultipleFormParams() {
        return MultipleFormParams;
    }

    public void setMultipleFormParams(MultipleFormParams MultipleFormParams) {
        this.MultipleFormParams=MultipleFormParams;
    }

    public MethodSingleParemeter getMethodSingleParemeter() {
        return MethodSingleParemeter;
    }

    public void setMethodSingleParemeter(MethodSingleParemeter MethodSingleParemeter) {
        this.MethodSingleParemeter=MethodSingleParemeter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.accept(visitor);
        if(MethodSingleParemeter!=null) MethodSingleParemeter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleFormParams!=null) MultipleFormParams.traverseTopDown(visitor);
        if(MethodSingleParemeter!=null) MethodSingleParemeter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleFormParams!=null) MultipleFormParams.traverseBottomUp(visitor);
        if(MethodSingleParemeter!=null) MethodSingleParemeter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFormalParameters(\n");

        if(MultipleFormParams!=null)
            buffer.append(MultipleFormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodSingleParemeter!=null)
            buffer.append(MethodSingleParemeter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFormalParameters]");
        return buffer.toString();
    }
}
