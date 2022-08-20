// generated with ast extension for cup
// version 0.8
// 20/7/2022 23:44:46


package rs.ac.bg.etf.pp1.ast;

public class DoWhileStatement extends SingleStatement {

    private DoWhileHeader DoWhileHeader;
    private Statement Statement;
    private DoWhileEnd DoWhileEnd;
    private Condition Condition;

    public DoWhileStatement (DoWhileHeader DoWhileHeader, Statement Statement, DoWhileEnd DoWhileEnd, Condition Condition) {
        this.DoWhileHeader=DoWhileHeader;
        if(DoWhileHeader!=null) DoWhileHeader.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.DoWhileEnd=DoWhileEnd;
        if(DoWhileEnd!=null) DoWhileEnd.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public DoWhileHeader getDoWhileHeader() {
        return DoWhileHeader;
    }

    public void setDoWhileHeader(DoWhileHeader DoWhileHeader) {
        this.DoWhileHeader=DoWhileHeader;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public DoWhileEnd getDoWhileEnd() {
        return DoWhileEnd;
    }

    public void setDoWhileEnd(DoWhileEnd DoWhileEnd) {
        this.DoWhileEnd=DoWhileEnd;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhileHeader!=null) DoWhileHeader.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(DoWhileEnd!=null) DoWhileEnd.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhileHeader!=null) DoWhileHeader.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(DoWhileEnd!=null) DoWhileEnd.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhileHeader!=null) DoWhileHeader.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(DoWhileEnd!=null) DoWhileEnd.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileStatement(\n");

        if(DoWhileHeader!=null)
            buffer.append(DoWhileHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DoWhileEnd!=null)
            buffer.append(DoWhileEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileStatement]");
        return buffer.toString();
    }
}
