// generated with ast extension for cup
// version 0.8
// 16/4/2022 8:55:50


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ListStatement ListStatement);
    public void visit(DesignatorFactor DesignatorFactor);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(AddExpr AddExpr);
    public void visit(ExtendsOper ExtendsOper);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(RecordStructure RecordStructure);
    public void visit(Designator Designator);
    public void visit(NewTypeFactor NewTypeFactor);
    public void visit(StatementsWithoutBraces StatementsWithoutBraces);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(Statements Statements);
    public void visit(MultipleDesignator MultipleDesignator);
    public void visit(DesignatorPostOperation DesignatorPostOperation);
    public void visit(MultipleVarDecl MultipleVarDecl);
    public void visit(FormParams FormParams);
    public void visit(Label Label);
    public void visit(ElseStatement ElseStatement);
    public void visit(MultipleFormParams MultipleFormParams);
    public void visit(LineVarDecl LineVarDecl);
    public void visit(Expr Expr);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(LineConstDecl LineConstDecl);
    public void visit(SingleMethodDecl SingleMethodDecl);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(Statement Statement);
    public void visit(Mdecl Mdecl);
    public void visit(VarDecl VarDecl);
    public void visit(Type Type);
    public void visit(ClassAllMethodDecl ClassAllMethodDecl);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(GlobalLineVarDecl GlobalLineVarDecl);
    public void visit(Program Program);
    public void visit(SingleStatement SingleStatement);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(Consts Consts);
    public void visit(MultipleNumConst MultipleNumConst);
    public void visit(ClassMethodDecl ClassMethodDecl);
    public void visit(LabelIdent LabelIdent);
    public void visit(TypeIdent TypeIdent);
    public void visit(CharacterConstant CharacterConstant);
    public void visit(NumberConstant NumberConstant);
    public void visit(BooleanConstant BooleanConstant);
    public void visit(NoNumConsts NoNumConsts);
    public void visit(NumConsts NumConsts);
    public void visit(RecordStruct RecordStruct);
    public void visit(ModulOperation ModulOperation);
    public void visit(DivOperation DivOperation);
    public void visit(MulOperation MulOperation);
    public void visit(MinusOp MinusOp);
    public void visit(PlusOp PlusOp);
    public void visit(LessEqualOp LessEqualOp);
    public void visit(LessOp LessOp);
    public void visit(GreaterEqualOp GreaterEqualOp);
    public void visit(GreaterOp GreaterOp);
    public void visit(NotEqualOp NotEqualOp);
    public void visit(IsEqualOp IsEqualOp);
    public void visit(AssignOperation AssignOperation);
    public void visit(DesignatorDecrement DesignatorDecrement);
    public void visit(DesignatorIncrement DesignatorIncrement);
    public void visit(ParDesignatorOp ParDesignatorOp);
    public void visit(ParActParsDesignatorOp ParActParsDesignatorOp);
    public void visit(AssignDesignatorOp AssignDesignatorOp);
    public void visit(DesignatorStat DesignatorStat);
    public void visit(MultipleActPars MultipleActPars);
    public void visit(OneActPars OneActPars);
    public void visit(DesignatorStructure DesignatorStructure);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(EmptyMultipleDesignator EmptyMultipleDesignator);
    public void visit(DesignatorFullExpresion DesignatorFullExpresion);
    public void visit(NewTypeArray NewTypeArray);
    public void visit(NewTypeNoArray NewTypeNoArray);
    public void visit(DesignatorOnly DesignatorOnly);
    public void visit(DesignatorConstrPar DesignatorConstrPar);
    public void visit(DesignatorConstr DesignatorConstr);
    public void visit(DesignatorFactorExpresion DesignatorFactorExpresion);
    public void visit(NewTypeFactorExpresion NewTypeFactorExpresion);
    public void visit(ParenExpresion ParenExpresion);
    public void visit(BoolConst BoolConst);
    public void visit(NumConst NumConst);
    public void visit(CharConst CharConst);
    public void visit(TermDerived2 TermDerived2);
    public void visit(TermDerived1 TermDerived1);
    public void visit(AddExptOnly AddExptOnly);
    public void visit(MinusExpr MinusExpr);
    public void visit(MultipleAddExpr MultipleAddExpr);
    public void visit(OneAddExpr OneAddExpr);
    public void visit(MultipleCondFact MultipleCondFact);
    public void visit(SingleCondFact SingleCondFact);
    public void visit(MultipleCondTerm MultipleCondTerm);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(MultipleIfCondition MultipleIfCondition);
    public void visit(SingleIfCondition SingleIfCondition);
    public void visit(StatementsRed StatementsRed);
    public void visit(OneStatementRed OneStatementRed);
    public void visit(ColStatementRed ColStatementRed);
    public void visit(NoStatements NoStatements);
    public void visit(MultipleStatements MultipleStatements);
    public void visit(MoreThenOneStatement MoreThenOneStatement);
    public void visit(OneStatement OneStatement);
    public void visit(HaveElseStatement HaveElseStatement);
    public void visit(NoElseStatement NoElseStatement);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(DoWhileStatement DoWhileStatement);
    public void visit(ReturnStatementExpr ReturnStatementExpr);
    public void visit(ReturnStatementNoExpr ReturnStatementNoExpr);
    public void visit(GotoStatement GotoStatement);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(DesignStatement DesignStatement);
    public void visit(IfElseStatement IfElseStatement);
    public void visit(NoStatement NoStatement);
    public void visit(MultipleStatement MultipleStatement);
    public void visit(MethodReturnTypeDerived2 MethodReturnTypeDerived2);
    public void visit(MethodReturnTypeDerived1 MethodReturnTypeDerived1);
    public void visit(NoFormalParameters NoFormalParameters);
    public void visit(FormalParameters FormalParameters);
    public void visit(OnlyFormalParameter OnlyFormalParameter);
    public void visit(MultipleFormalParameters MultipleFormalParameters);
    public void visit(OneMethodDeclaration OneMethodDeclaration);
    public void visit(MultipleMethodDeclaration MultipleMethodDeclaration);
    public void visit(SingleMethodDeclaration SingleMethodDeclaration);
    public void visit(ConstructorDeclaration ConstructorDeclaration);
    public void visit(EmptyExtends EmptyExtends);
    public void visit(Extends Extends);
    public void visit(EmptyClassAllMethodDeclaration EmptyClassAllMethodDeclaration);
    public void visit(MethodDeclarationOnly MethodDeclarationOnly);
    public void visit(SingleConstructorDeclaration SingleConstructorDeclaration);
    public void visit(ClassAllMethodDeclaration ClassAllMethodDeclaration);
    public void visit(ClassDeclDerived1 ClassDeclDerived1);
    public void visit(EmptyVariableDecl EmptyVariableDecl);
    public void visit(MultipleVariableDecl MultipleVariableDecl);
    public void visit(EmptyArrayOperator EmptyArrayOperator);
    public void visit(ArrayOperator ArrayOperator);
    public void visit(EmptyLineVariableDecl EmptyLineVariableDecl);
    public void visit(LineVariableDecl LineVariableDecl);
    public void visit(ErrorLineVariableDecl ErrorLineVariableDecl);
    public void visit(EmptyGlobalLineVariableDecl EmptyGlobalLineVariableDecl);
    public void visit(GlobalLineVariableDecl GlobalLineVariableDecl);
    public void visit(SingleVariableDecl SingleVariableDecl);
    public void visit(VariableDecl VariableDecl);
    public void visit(ErrorVarDecl ErrorVarDecl);
    public void visit(GlobalVariableDecl GlobalVariableDecl);
    public void visit(LineConstDeclDerived1 LineConstDeclDerived1);
    public void visit(LineConstantDecl LineConstantDecl);
    public void visit(SimpleConstDecl SimpleConstDecl);
    public void visit(ConstantDecl ConstantDecl);
    public void visit(EmptyDeclaration EmptyDeclaration);
    public void visit(RecordDeclaration RecordDeclaration);
    public void visit(ClassDecleration ClassDecleration);
    public void visit(GlobalVariableDeclaration GlobalVariableDeclaration);
    public void visit(ConstantDeclaration ConstantDeclaration);
    public void visit(ProgName ProgName);
    public void visit(ProgramWithoutMethods ProgramWithoutMethods);
    public void visit(ProgramWithMethods ProgramWithMethods);

}