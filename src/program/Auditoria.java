package program;

public class Auditoria {

	  public void iniciarAuditoria(IBanco banco){
	    AuditorBancoGenerico auditor = new AuditorBancoGenerico();
	    auditor.auditar(banco);
	  }
}