package program;

public class ArrayContas implements IRepositorioConta {

	private ContaAbstrata[] contas = new ContaAbstrata[100];
	private int indice = 0;
	 public ArrayContas() {
	    }
	public void inserir(ContaAbstrata conta) {
		contas[indice] = conta;
		indice++;
	}

	public ContaAbstrata procurar(String numero) {
		for (int i = 0; i < indice; i++) {
			if (contas[i].getNumero().equals(numero)) {
				return contas[i];
			}
		}
		return null;
	}

	public int tamanho() {
		return contas.length;
	}
	
	public ContaAbstrata[] listar() {
		return contas;
	}
	
	public void remover(String numero){
		for (int i = 0; i < indice; i++) {
			if (contas[i].getNumero().equals(numero)) {
				contas[i]=null;
			}
		}
	}
}
