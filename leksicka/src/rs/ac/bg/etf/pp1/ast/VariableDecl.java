// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class VariableDecl extends VarDecl {

    private SingleVarDecl SingleVarDecl;
    private LineVarDecl LineVarDecl;

    public VariableDecl (SingleVarDecl SingleVarDecl, LineVarDecl LineVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
        if(SingleVarDecl!=null) SingleVarDecl.setParent(this);
        this.LineVarDecl=LineVarDecl;
        if(LineVarDecl!=null) LineVarDecl.setParent(this);
    }

    public SingleVarDecl getSingleVarDecl() {
        return SingleVarDecl;
    }

    public void setSingleVarDecl(SingleVarDecl SingleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
    }

    public LineVarDecl getLineVarDecl() {
        return LineVarDecl;
    }

    public void setLineVarDecl(LineVarDecl LineVarDecl) {
        this.LineVarDecl=LineVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.accept(visitor);
        if(LineVarDecl!=null) LineVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseTopDown(visitor);
        if(LineVarDecl!=null) LineVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.traverseBottomUp(visitor);
        if(LineVarDecl!=null) LineVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDecl(\n");

        if(SingleVarDecl!=null)
            buffer.append(SingleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LineVarDecl!=null)
            buffer.append(LineVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDecl]");
        return buffer.toString();
    }
}
