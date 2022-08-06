// generated with ast extension for cup
// version 0.8
// 6/7/2022 13:57:53


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends SingleStatement {

    private Expr Expr;
    private MultipleNumConst MultipleNumConst;

    public PrintStatement (Expr Expr, MultipleNumConst MultipleNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MultipleNumConst=MultipleNumConst;
        if(MultipleNumConst!=null) MultipleNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MultipleNumConst getMultipleNumConst() {
        return MultipleNumConst;
    }

    public void setMultipleNumConst(MultipleNumConst MultipleNumConst) {
        this.MultipleNumConst=MultipleNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(MultipleNumConst!=null) MultipleNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MultipleNumConst!=null) MultipleNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MultipleNumConst!=null) MultipleNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleNumConst!=null)
            buffer.append(MultipleNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
