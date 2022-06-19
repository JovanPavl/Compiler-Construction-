// generated with ast extension for cup
// version 0.8
// 19/5/2022 17:40:43


package rs.ac.bg.etf.pp1.ast;

public class MethodReturnTypeDerived2 extends MethodReturnType {

    public MethodReturnTypeDerived2 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodReturnTypeDerived2(\n");

        buffer.append(tab);
        buffer.append(") [MethodReturnTypeDerived2]");
        return buffer.toString();
    }
}
