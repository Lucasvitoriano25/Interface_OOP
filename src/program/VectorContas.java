package program;

import java.util.Vector;

public class VectorContas implements IRepositorioConta {
	private Vector<ContaAbstrata> contas = new Vector<ContaAbstrata>();

	
	 public VectorContas() {
	}
	public void inserir(ContaAbstrata conta) {
		if(conta != null) {
			contas.add(conta);
		}
		else {
			
		}
	}

	public ContaAbstrata procurar(String numero) {
		for (ContaAbstrata conta : contas) {
			if (conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		return null;
	}

	public int tamanho() {
		return contas.size();
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata[] continhas = new ContaAbstrata[contas.size()];
		int i = 0;
		for (ContaAbstrata conta : contas) {
			continhas[i++] = conta;
		}
		return continhas;
	}

	public void remover(String numero) {
		for (ContaAbstrata conta : contas) {
			if (conta.getNumero().equals(numero)) {
				contas.remove(conta);
			}
		}
	}
}