package program;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Escolha a opção desejada:\n 1) Testa BancoIndependente\n 2) Testa AuditorBancoGenerico\n 3) Testa Auditoria");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			testaBancoIndependente();
			break;

		case 2:
			testaAuditorBancoGenerico();
			break;

		case 3:
			testaAuditoria();
			break;

		default:
			System.out.println("Opção inexistente!");
			break;
		}
		sc.close();
	}

	public static void testaBancoIndependente() {
		BancoIndependente BancoDoBrasil = new BancoIndependente(new VectorContas());
		Conta ContadoJeff = new ContaPoupanca("123");
		Conta ContadoBill = new Conta("1234");
		BancoDoBrasil.setTaxa(0.5);
		BancoDoBrasil.cadastrar(ContadoJeff);
		BancoDoBrasil.cadastrar(ContadoBill);


		ContadoJeff.creditar(200.0);
		if (BancoDoBrasil.saldo("123") == 200.0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
		BancoDoBrasil.debitar("123", 100.0);
		if (BancoDoBrasil.saldo("123") == 100.0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}

		BancoDoBrasil.renderJuros("123");
		if (BancoDoBrasil.saldo("123") == 150.0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}

		BancoDoBrasil.cadastrar(ContadoBill);
		ContadoBill.creditar(200.0);
		BancoDoBrasil.debitar("1234", 100.0);
		if (BancoDoBrasil.saldo("1234") == 100.0) {
			System.out.println("TRUE");
		}
		BancoDoBrasil.transferir("123", "1234", 100.0);
		if (BancoDoBrasil.saldo("123") == 50.0 && BancoDoBrasil.saldo("1234") == 200.0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
		ContaEspecial ContadoElon = new ContaEspecial("12345");

		BancoDoBrasil.cadastrar(ContadoElon);
		BancoDoBrasil.creditar("12345", 100.0);
		BancoDoBrasil.renderBonus("12345");
		if (BancoDoBrasil.saldo("12345") == 101.0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
		ContaImposto ContadoSteve = new ContaImposto("123456");

		BancoDoBrasil.cadastrar(ContadoSteve);
		BancoDoBrasil.creditar("123456", 100.0);
		BancoDoBrasil.debitar("123456", 50.0);
		if (BancoDoBrasil.saldo("123456") == 49.95) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	public static void testaAuditorBancoGenerico() {
		BancoIndependente BancoDoBrasil = new BancoIndependente(new VectorContas());
		Conta ContadoJeff = new ContaPoupanca("123");
		Conta ContadoBill = new Conta("1234");

		BancoDoBrasil.cadastrar(ContadoJeff);
		BancoDoBrasil.cadastrar(ContadoBill);
		
		BancoDoBrasil.creditar("123",100.0);
		BancoDoBrasil.creditar("1234",1000.0);


		AuditorBancoGenerico AuditorBancoDoBrasil = new AuditorBancoGenerico();
		System.out.println("Resposta esperada : Aprovado");
		AuditorBancoDoBrasil.auditar(BancoDoBrasil);

		Conta ContadoHumilde = new ContaPoupanca("12345");
		BancoDoBrasil.cadastrar(ContadoHumilde);
		
		System.out.println("Resposta esperada : Reprovado");
		AuditorBancoDoBrasil.auditar(BancoDoBrasil);

		
	}

	public static void testaAuditoria() {
		BancoIndependente BancoDoBrasil = new BancoIndependente(new VectorContas());
		Conta ContadoJeff = new ContaPoupanca("123");
		Conta ContadoBill = new Conta("1234");

		BancoDoBrasil.cadastrar(ContadoJeff);
		BancoDoBrasil.cadastrar(ContadoBill);
		
		BancoDoBrasil.creditar("123",1000.0);
		BancoDoBrasil.creditar("1234",100.0);

		System.out.println("Resposta esperada : Aprovado");
		Auditoria AuditarBancoDoBrasil = new Auditoria();
		AuditarBancoDoBrasil.iniciarAuditoria(BancoDoBrasil);
		
		Conta ContadoHumilde = new ContaPoupanca("12345");
		BancoDoBrasil.cadastrar(ContadoHumilde);
		BancoDoBrasil.creditar("12345",100.0);
		
		System.out.println("Resposta esperada : Reprovado");
		AuditarBancoDoBrasil.iniciarAuditoria(BancoDoBrasil);
	}

}