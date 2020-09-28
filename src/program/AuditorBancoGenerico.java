package program;

public class AuditorBancoGenerico {
	
	public AuditorBancoGenerico() {
	}
	
	public void auditar(IBanco Banco) {
		double valor = Banco.saldoTotal() / Banco.numeroContas();
		if (valor > 500) {
			System.out.println("Aprovado");
		} else {
			System.out.println("Reprovado");
		}
	}

}
