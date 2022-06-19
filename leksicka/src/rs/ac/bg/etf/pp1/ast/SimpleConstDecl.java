// generated with ast extension for cup
// version 0.8
// 19/5/2022 17:40:43


package rs.ac.bg.etf.pp1.ast;

public class SimpleConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private Consts Consts;

    public SimpleConstDecl (String I1, Consts Consts) {
        this.I1=I1;
        this.Consts=Consts;
        if(Consts!=null) Consts.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Consts getConsts() {
        return Consts;
    }

    public void setConsts(Consts Consts) {
        this.Consts=Consts;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Consts!=null) Consts.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Consts!=null) Consts.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Consts!=null) Consts.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SimpleConstDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Consts!=null)
            buffer.append(Consts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleConstDecl]");
        return buffer.toString();
    }
}
