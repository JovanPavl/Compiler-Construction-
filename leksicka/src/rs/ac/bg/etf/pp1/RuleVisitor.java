package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import org.apache.log4j.*;
public class RuleVisitor extends VisitorAdaptor{
	
	Logger log = Logger.getLogger(MJParserTest.class);
	public void visit(Program Program) {
		log.info("Program recognized\n");
	}
}
