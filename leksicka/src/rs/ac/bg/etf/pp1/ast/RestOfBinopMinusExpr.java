// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class RestOfBinopMinusExpr extends RestOfBinop {

    private AddExpr AddExpr;

    public RestOfBinopMinusExpr (AddExpr AddExpr) {
        this.AddExpr=AddExpr;
        if(AddExpr!=null) AddExpr.setParent(this);
    }

    public AddExpr getAddExpr() {
        return AddExpr;
    }

    public void setAddExpr(AddExpr AddExpr) {
        this.AddExpr=AddExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddExpr!=null) AddExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddExpr!=null) AddExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddExpr!=null) AddExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RestOfBinopMinusExpr(\n");

        if(AddExpr!=null)
            buffer.append(AddExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RestOfBinopMinusExpr]");
        return buffer.toString();
    }
}
