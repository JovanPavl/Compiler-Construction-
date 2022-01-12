// generated with ast extension for cup
// version 0.8
// 12/0/2022 12:21:18


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclDerived1 extends ClassDecl {

    private ExtendsOper ExtendsOper;
    private MultipleVarDecl MultipleVarDecl;
    private ClassAllMethodDecl ClassAllMethodDecl;

    public ClassDeclDerived1 (ExtendsOper ExtendsOper, MultipleVarDecl MultipleVarDecl, ClassAllMethodDecl ClassAllMethodDecl) {
        this.ExtendsOper=ExtendsOper;
        if(ExtendsOper!=null) ExtendsOper.setParent(this);
        this.MultipleVarDecl=MultipleVarDecl;
        if(MultipleVarDecl!=null) MultipleVarDecl.setParent(this);
        this.ClassAllMethodDecl=ClassAllMethodDecl;
        if(ClassAllMethodDecl!=null) ClassAllMethodDecl.setParent(this);
    }

    public ExtendsOper getExtendsOper() {
        return ExtendsOper;
    }

    public void setExtendsOper(ExtendsOper ExtendsOper) {
        this.ExtendsOper=ExtendsOper;
    }

    public MultipleVarDecl getMultipleVarDecl() {
        return MultipleVarDecl;
    }

    public void setMultipleVarDecl(MultipleVarDecl MultipleVarDecl) {
        this.MultipleVarDecl=MultipleVarDecl;
    }

    public ClassAllMethodDecl getClassAllMethodDecl() {
        return ClassAllMethodDecl;
    }

    public void setClassAllMethodDecl(ClassAllMethodDecl ClassAllMethodDecl) {
        this.ClassAllMethodDecl=ClassAllMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsOper!=null) ExtendsOper.accept(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.accept(visitor);
        if(ClassAllMethodDecl!=null) ClassAllMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsOper!=null) ExtendsOper.traverseTopDown(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseTopDown(visitor);
        if(ClassAllMethodDecl!=null) ClassAllMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsOper!=null) ExtendsOper.traverseBottomUp(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseBottomUp(visitor);
        if(ClassAllMethodDecl!=null) ClassAllMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclDerived1(\n");

        if(ExtendsOper!=null)
            buffer.append(ExtendsOper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleVarDecl!=null)
            buffer.append(MultipleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassAllMethodDecl!=null)
            buffer.append(ClassAllMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclDerived1]");
        return buffer.toString();
    }
}
