// generated with ast extension for cup
// version 0.8
// 10/7/2022 0:29:1


package rs.ac.bg.etf.pp1.ast;

public class NumConsts extends MultipleNumConst {

    private MultipleNumConst MultipleNumConst;
    private Integer N2;

    public NumConsts (MultipleNumConst MultipleNumConst, Integer N2) {
        this.MultipleNumConst=MultipleNumConst;
        if(MultipleNumConst!=null) MultipleNumConst.setParent(this);
        this.N2=N2;
    }

    public MultipleNumConst getMultipleNumConst() {
        return MultipleNumConst;
    }

    public void setMultipleNumConst(MultipleNumConst MultipleNumConst) {
        this.MultipleNumConst=MultipleNumConst;
    }

    public Integer getN2() {
        return N2;
    }

    public void setN2(Integer N2) {
        this.N2=N2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleNumConst!=null) MultipleNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleNumConst!=null) MultipleNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleNumConst!=null) MultipleNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumConsts(\n");

        if(MultipleNumConst!=null)
            buffer.append(MultipleNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConsts]");
        return buffer.toString();
    }
}
