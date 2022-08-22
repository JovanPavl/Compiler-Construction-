// generated with ast extension for cup
// version 0.8
// 22/7/2022 13:18:30


package rs.ac.bg.etf.pp1.ast;

public class OnlyFormalParameter extends MultipleFormParams {

    private MethodSingleParemeter MethodSingleParemeter;

    public OnlyFormalParameter (MethodSingleParemeter MethodSingleParemeter) {
        this.MethodSingleParemeter=MethodSingleParemeter;
        if(MethodSingleParemeter!=null) MethodSingleParemeter.setParent(this);
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
        if(MethodSingleParemeter!=null) MethodSingleParemeter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSingleParemeter!=null) MethodSingleParemeter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSingleParemeter!=null) MethodSingleParemeter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OnlyFormalParameter(\n");

        if(MethodSingleParemeter!=null)
            buffer.append(MethodSingleParemeter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OnlyFormalParameter]");
        return buffer.toString();
    }
}
