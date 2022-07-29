// generated with ast extension for cup
// version 0.8
// 24/6/2022 18:49:22


package rs.ac.bg.etf.pp1.ast;

public class ConstantDecl extends ConstDecl {

    private Type Type;
    private SimpleConstDecl SimpleConstDecl;
    private LineConstDecl LineConstDecl;

    public ConstantDecl (Type Type, SimpleConstDecl SimpleConstDecl, LineConstDecl LineConstDecl) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.SimpleConstDecl=SimpleConstDecl;
        if(SimpleConstDecl!=null) SimpleConstDecl.setParent(this);
        this.LineConstDecl=LineConstDecl;
        if(LineConstDecl!=null) LineConstDecl.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(SimpleConstDecl!=null) SimpleConstDecl.accept(visitor);
        if(LineConstDecl!=null) LineConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SimpleConstDecl!=null) SimpleConstDecl.traverseTopDown(visitor);
        if(LineConstDecl!=null) LineConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SimpleConstDecl!=null) SimpleConstDecl.traverseBottomUp(visitor);
        if(LineConstDecl!=null) LineConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [ConstantDecl]");
        return buffer.toString();
    }
}
