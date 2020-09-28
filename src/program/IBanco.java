package program;

public interface IBanco {
	public double saldoTotal();

	public int numeroContas();

	public void cadastrar(ContaAbstrata conta);

	public ContaAbstrata procurar(String numero);

	public void creditar(String numero, double valor);

	public void debitar(String numero, double valor);

	public void transferir(String origem, String destino, double valor);

	public double saldo(String numero);

	public void renderJuros(String numero);

	public void renderBonus(String numero);
}