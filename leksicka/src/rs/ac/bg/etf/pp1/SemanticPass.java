package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());

	public boolean errorDetected = false;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line ").append(line);
		log.info(msg.toString());
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		log.debug("Program name recognized " + progName.getLine() + " \n");
		Tab.openScope();
	}

	public void visit(DesignatorStructure designatorStructure) {
		report_info("DesignatorStructure found", designatorStructure);
	}

	public void visit(DesignatorArray designatorArray) {
		report_info("DesignatorArray", designatorArray);
	}
	
	public boolean passed() {
		return !errorDetected;
	}
}