package program;

public interface IRepositorioConta {
	public void inserir(ContaAbstrata conta);

	public void remover(String numero);

	public ContaAbstrata procurar(String numero);

	public ContaAbstrata[] listar();

	public int tamanho();
}