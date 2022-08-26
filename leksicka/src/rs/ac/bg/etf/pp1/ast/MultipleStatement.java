// generated with ast extension for cup
// version 0.8
// 26/7/2022 0:26:56


package rs.ac.bg.etf.pp1.ast;

public class MultipleStatement extends ListStatement {

    private ListStatement ListStatement;
    private Statement Statement;

    public MultipleStatement (ListStatement ListStatement, Statement Statement) {
        this.ListStatement=ListStatement;
        if(ListStatement!=null) ListStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ListStatement getListStatement() {
        return ListStatement;
    }

    public void setListStatement(ListStatement ListStatement) {
        this.ListStatement=ListStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListStatement!=null) ListStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListStatement!=null) ListStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListStatement!=null) ListStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleStatement(\n");

        if(ListStatement!=null)
            buffer.append(ListStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleStatement]");
        return buffer.toString();
    }
}
