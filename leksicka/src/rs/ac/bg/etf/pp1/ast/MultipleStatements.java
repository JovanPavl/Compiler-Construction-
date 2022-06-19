// generated with ast extension for cup
// version 0.8
// 19/5/2022 17:40:43


package rs.ac.bg.etf.pp1.ast;

public class MultipleStatements extends Statements {

    private StatementsWithoutBraces StatementsWithoutBraces;

    public MultipleStatements (StatementsWithoutBraces StatementsWithoutBraces) {
        this.StatementsWithoutBraces=StatementsWithoutBraces;
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.setParent(this);
    }

    public StatementsWithoutBraces getStatementsWithoutBraces() {
        return StatementsWithoutBraces;
    }

    public void setStatementsWithoutBraces(StatementsWithoutBraces StatementsWithoutBraces) {
        this.StatementsWithoutBraces=StatementsWithoutBraces;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementsWithoutBraces!=null) StatementsWithoutBraces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleStatements(\n");

        if(StatementsWithoutBraces!=null)
            buffer.append(StatementsWithoutBraces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleStatements]");
        return buffer.toString();
    }
}
