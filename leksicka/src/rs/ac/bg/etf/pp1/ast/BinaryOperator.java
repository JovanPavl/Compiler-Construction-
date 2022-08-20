// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class BinaryOperator extends Expr {

    private Expr Expr;
    private RestOfBinop restOfBinop;

    public BinaryOperator (Expr Expr, RestOfBinop restOfBinop) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.restOfBinop=restOfBinop;
        if(restOfBinop!=null) restOfBinop.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public RestOfBinop getRestOfBinop() {
        return restOfBinop;
    }

    public void setRestOfBinop(RestOfBinop restOfBinop) {
        this.restOfBinop=restOfBinop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(restOfBinop!=null) restOfBinop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(restOfBinop!=null) restOfBinop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(restOfBinop!=null) restOfBinop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BinaryOperator(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(restOfBinop!=null)
            buffer.append(restOfBinop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BinaryOperator]");
        return buffer.toString();
    }
}
