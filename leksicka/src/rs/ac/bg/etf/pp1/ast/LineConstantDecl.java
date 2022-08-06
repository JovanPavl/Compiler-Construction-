// generated with ast extension for cup
// version 0.8
// 5/7/2022 22:26:46


package rs.ac.bg.etf.pp1.ast;

public class LineConstantDecl extends LineConstDecl {

    private SimpleConstDecl SimpleConstDecl;
    private LineConstDecl LineConstDecl;

    public LineConstantDecl (SimpleConstDecl SimpleConstDecl, LineConstDecl LineConstDecl) {
        this.SimpleConstDecl=SimpleConstDecl;
        if(SimpleConstDecl!=null) SimpleConstDecl.setParent(this);
        this.LineConstDecl=LineConstDecl;
        if(LineConstDecl!=null) LineConstDecl.setParent(this);
    }

    public SimpleConstDecl getSimpleConstDecl() {
        return SimpleConstDecl;
    }

    public void setSimpleConstDecl(SimpleConstDecl SimpleConstDecl) {
        this.SimpleConstDecl=SimpleConstDecl;
    }

    public LineConstDecl getLineConstDecl() {
        return LineConstDecl;
    }

    public void setLineConstDecl(LineConstDecl LineConstDecl) {
        this.LineConstDecl=LineConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SimpleConstDecl!=null) SimpleConstDecl.accept(visitor);
        if(LineConstDecl!=null) LineConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SimpleConstDecl!=null) SimpleConstDecl.traverseTopDown(visitor);
        if(LineConstDecl!=null) LineConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SimpleConstDecl!=null) SimpleConstDecl.traverseBottomUp(visitor);
        if(LineConstDecl!=null) LineConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LineConstantDecl(\n");

        if(SimpleConstDecl!=null)
            buffer.append(SimpleConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LineConstDecl!=null)
            buffer.append(LineConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LineConstantDecl]");
        return buffer.toString();
    }
}
