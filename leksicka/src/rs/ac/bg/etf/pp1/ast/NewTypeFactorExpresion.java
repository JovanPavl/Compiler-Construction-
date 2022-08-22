// generated with ast extension for cup
// version 0.8
// 22/7/2022 13:18:30


package rs.ac.bg.etf.pp1.ast;

public class NewTypeFactorExpresion extends Factor {

    private NewTypeFactor NewTypeFactor;

    public NewTypeFactorExpresion (NewTypeFactor NewTypeFactor) {
        this.NewTypeFactor=NewTypeFactor;
        if(NewTypeFactor!=null) NewTypeFactor.setParent(this);
    }

    public NewTypeFactor getNewTypeFactor() {
        return NewTypeFactor;
    }

    public void setNewTypeFactor(NewTypeFactor NewTypeFactor) {
        this.NewTypeFactor=NewTypeFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NewTypeFactor!=null) NewTypeFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NewTypeFactor!=null) NewTypeFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NewTypeFactor!=null) NewTypeFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewTypeFactorExpresion(\n");

        if(NewTypeFactor!=null)
            buffer.append(NewTypeFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewTypeFactorExpresion]");
        return buffer.toString();
    }
}
