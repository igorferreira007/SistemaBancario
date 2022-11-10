import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaBanco {
	public static void menu() {
		System.out.println("1. Cadastrar");
		System.err.println("2. Remover");
		System.out.println("3. Consultar");
		System.out.println("4. Ajustar Limite");
		System.out.println("5. Transferencia");
		System.out.println("6. Adicionar Saldo");
		System.out.println("7.Relatorio de Clientes");
		System.out.println("8. Sair");
	}

	public static void menuTipoCliente() {
		System.out.println("1. Pessoa Fisica");
		System.out.println("2. Pessoa Juridica");
	}

	public static void dadosPessoaF(Scanner ler, int cont, PessoaFisica[] pfs) {
		System.out.println("Conta:");
		String conta = ler.nextLine();
		System.out.println("Agencia:");
		String agencia = ler.nextLine();
		System.out.println("Telefone:");
		String telefone = ler.nextLine();
		System.out.println("Saldo:");
		double saldo = ler.nextDouble();
		System.out.println("Limite:");
		double limite = ler.nextDouble();
		ler.nextLine();
		System.out.println("CPF:");
		String cpf = ler.nextLine();
		System.out.println("Nome:");
		String nome = ler.nextLine();
		System.out.println("Idade:");
		int idade = ler.nextInt();
		PessoaFisica p = new PessoaFisica(conta, agencia, telefone, saldo, limite, cpf, nome, idade);
//		p.consultaPessoaF();
		pfs[cont] = p;
		System.out.println(cont);
	}

	public static void dadosPessoaJ(Scanner ler) {
		System.out.println("Conta:");
		String conta = ler.nextLine();
		System.out.println("Agencia:");
		String agencia = ler.nextLine();
		System.out.println("Telefone:");
		String telefone = ler.nextLine();
		System.out.println("Saldo:");
		double saldo = ler.nextDouble();
		System.out.println("Limite:");
		double limite = ler.nextDouble();
		System.out.println("CPF:");
		String cnpj = ler.nextLine();
		System.out.println("Nome:");
		String[] nome = new String[3];
		nome[0] = ler.nextLine();
		nome[1] = ler.nextLine();
		nome[2] = ler.nextLine();
		System.out.println("Razao Social:");
		String razaoSocial = ler.nextLine();
		System.out.println("Nome Fantasia:");
		String nomeFantasia = ler.nextLine();
		PessoaJuridica p = new PessoaJuridica(conta, agencia, telefone, saldo, limite, cnpj, nome, razaoSocial,
				nomeFantasia);

	}

	public static void exibeTodosPessoaF(PessoaFisica[] pfs) {
		for (PessoaFisica pessoaFisica : pfs) {
			if (pessoaFisica != null) {
				System.out.println(pessoaFisica.getNome());
				
			}
		}
	}
	
	public static void pesquisaPessoaF(PessoaFisica[] pfs, String conta) {
		boolean contaInvalida = false;
		for (int i = 0; i < pfs.length; i++) {
			if (pfs[i] != null && pfs[i].getConta().equals(conta)) {
				pfs[i].consultaPessoaF();
				contaInvalida = true;
				break;
			}
		}
		if (!contaInvalida) {
			System.out.println("Pessoa nao cadastrada!");
		}
	}

	public static void removePessoaF(PessoaFisica[] pfs, String cpf) {
		boolean cpfInvalido = false;
		for (int i = 0; i < pfs.length; i++) {
			if (pfs[i] != null && pfs[i].getCpf().equals(cpf)) {
				pfs[i] = null;
				cpfInvalido = true;
				break;
			}
		}
		if (!cpfInvalido) {
			System.out.println("Pessoa nao cadastrada!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		int cont = 0;
		PessoaFisica[] pfs = new PessoaFisica[50];
		do {
			menu();
			try {
				opcao = ler.nextInt();
				ler = new Scanner(System.in);
				switch (opcao) {
				case 1:
					menuTipoCliente();
					opcao = ler.nextInt();
					ler.nextLine();
					switch (opcao) {
					case 1:
						dadosPessoaF(ler, cont, pfs);
						cont++;
						break;
					}
					break;
				case 2:
					System.out.println("Informe o CPF:");
					String cpf = ler.nextLine();
					removePessoaF(pfs, cpf);
					break;
				case 3:
					System.out.println("Informe a conta:");
					String conta = ler.nextLine();
					pesquisaPessoaF(pfs, conta);
					break;
				case 7:
					exibeTodosPessoaF(pfs);
					break;

				default:

					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Digite um valor correto!");
			}

		} while (opcao != 8);

	}

}