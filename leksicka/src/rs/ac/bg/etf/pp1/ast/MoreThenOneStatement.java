// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class MoreThenOneStatement extends StatementsWithoutBraces {

    private StatementsWithoutBraces StatementsWithoutBraces;
    private Statement Statement;

    public MoreThenOneStatement (StatementsWithoutBraces StatementsWithoutBraces, Statement Statement) {
        this.StatementsWithoutBraces=StatementsWithoutBraces;
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementsWithoutBraces getStatementsWithoutBraces() {
        return StatementsWithoutBraces;
    }

    public void setStatementsWithoutBraces(StatementsWithoutBraces StatementsWithoutBraces) {
        this.StatementsWithoutBraces=StatementsWithoutBraces;
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
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreThenOneStatement(\n");

        if(StatementsWithoutBraces!=null)
            buffer.append(StatementsWithoutBraces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreThenOneStatement]");
        return buffer.toString();
    }
}
