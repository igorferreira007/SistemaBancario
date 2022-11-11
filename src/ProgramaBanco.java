
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaBanco {
    public static void menu() {
        System.out.println("1. Cadastrar");
        System.out.println("2. Remover");
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
//      p.consultaPessoaF();
        pfs[cont] = p;
        System.out.println(cont);
    }


    public static void dadosPessoaJ(Scanner ler, int cont, PessoaJuridica[] pjd) {
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
        clearBuffer(ler);
        System.out.println("CNPJ:");
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
        pjd[cont] = p;


    }

    public static void exibeTodosPessoaF(PessoaFisica[] pfs) {
        System.out.println("Clientes PF:");
        for (PessoaFisica pessoaFisica : pfs) {
            if (pessoaFisica != null) {
                System.out.println("Nome do Cliente:" + pessoaFisica.getNome());

            }
        }
    }

    // Exibir relatorio Juridico
    public static void exibeTodosPessoaJ(PessoaJuridica[] pfs) {
        boolean pessoaExiste = false;
        System.out.println("Clientes PJ:");
        for (PessoaJuridica pessoaJuridica : pfs) {
        if (pessoaJuridica != null) {

            System.out.println("Razão Social: " + pessoaJuridica.getRazaoSocial());

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

    public static void pesquisaPessoaJ(PessoaJuridica[] pfs, String conta) {
        boolean contaInvalida = false;
        for (int i = 0; i < pfs.length; i++) {
            if (pfs[i] != null && pfs[i].getConta().equals(conta)) {
                pfs[i].consultaPessoaJ();
                contaInvalida = true;
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }

    public static void removePessoaF(PessoaFisica[] pfs, String conta) {
        boolean contaInvalida = false;
        for (int i = 0; i < pfs.length; i++) {
            if (pfs[i] != null && pfs[i].getConta().equals(conta)) {
                pfs[i] = null;
                contaInvalida = true;
                System.out.println("Pessoa removida");
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }

    public static void removePessoaJ(PessoaJuridica[] pjs, String conta) {
        boolean contaInvalida = false;
        for (int i = 0; i < pjs.length; i++) {
            if (pjs[i] != null && pjs[i].getConta().equals(conta)) {
                pjs[i] = null;
                contaInvalida = true;
                System.out.println("Pessoa removida");
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void adicionaSaldoF(PessoaFisica[] pfs, String conta, double valor) {
        boolean contaInvalida = false;
        for (int i = 0; i < pfs.length; i++) {
            if (pfs[i] != null && pfs[i].getConta().equals(conta)) {
                pfs[i].setSaldo(pfs[i].getSaldo() + valor);;
                contaInvalida = true;
                System.out.println("Saldo adicionado!");
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }
    
    public static void adicionaSaldoJ(PessoaJuridica[] pjd, String conta, double valor) {
        boolean contaInvalida = false;
        for (int i = 0; i < pjd.length; i++) {
            if (pjd[i] != null && pjd[i].getConta().equals(conta)) {
                pjd[i].setSaldo(pjd[i].getSaldo() + valor);
                contaInvalida = true;
                System.out.println("Saldo adicionado!");
                break;
            }
        }
        if (contaInvalida = false) {
            System.out.println("Pessoa nao cadastrada!");
        }

    }

    public static void ajustaLimitePF(PessoaFisica [] pfs, String conta, double limite) {
        boolean contaInvalida = false;
        for (int i = 0; i < pfs.length; i++) {
            if (pfs[i] != null && pfs[i].getConta().equals(conta)) {
                pfs[i].setLimite(limite);
                contaInvalida = true;
                System.out.println("Limite alterado!");
                break;
            }
        }
        if (contaInvalida = false) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }

    public static void ajustaLimitePJ(PessoaJuridica [] pjd, String conta, double limite) {
        boolean contaInvalida = false;
        for (int i = 0; i < pjd.length; i++) {
            if (pjd[i] != null && pjd[i].getConta().equals(conta)) {
                pjd[i].setLimite(limite);
                contaInvalida = true;
                System.out.println("Limite alterado!");
                break;
            }
        }
        if (contaInvalida = false) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }




    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        int cont = 0;
        PessoaFisica[] pfs = new PessoaFisica[50];
        PessoaJuridica[] pjd = new PessoaJuridica[50];
        do {
            menu();
            try {
                opcao = ler.nextInt();
                clearBuffer(ler);
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
                            case 2:
                                dadosPessoaJ(ler, cont, pjd);
                                cont++;
                        }
                        break;
                    case 2:
                        menuTipoCliente();
                        opcao = ler.nextInt();
                        ler.nextLine();

                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta da PF:");
                                String contaF = ler.nextLine();
                                removePessoaF(pfs, contaF);
                                cont--;
                                break;
                            case 2:
                                System.out.println("Informe a conta da PJ:");
                                String contaJ = ler.nextLine();
                                removePessoaJ(pjd , contaJ);
                                cont--;
                                break;
                        }
                        break;
                    case 3:
                        menuTipoCliente();
                        opcao = ler.nextInt();
                        clearBuffer(ler);
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta:");
                                String conta = ler.nextLine();
                                pesquisaPessoaF(pfs, conta);
                                break;
                            case 2:
                                System.out.println("Informe a conta:");
                                conta = ler.nextLine();
                                pesquisaPessoaJ(pjd, conta);
                                break;
                        }
                        break;
                    case 4:
                       menuTipoCliente();
                       opcao = ler.nextInt();
                       switch (opcao) {
                           case 1:
                               System.out.println("Informe a conta PF:");
                               String conta = ler.nextLine();
                               double limite = 0;
                               while (limite < 0) {
                                   System.out.println("Informe o novo limite:");
                                    limite = ler.nextDouble();
                               }
                               ajustaLimitePF(pfs, conta, limite);
                               break;
                           case 2:
                               System.out.println("Informe a conta PJ:");
                               conta = ler.nextLine();
                               limite = 0;
                               while (limite < 0) {
                                   System.out.println("Informe o novo limite:");
                                   limite = ler.nextDouble();
                                   if (limite < 0) {
                                       System.out.println("Digite um valor válido!");
                                   }
                               }
                               ajustaLimitePJ(pjd, conta, limite);
                               break;
                       }
                        break;
                    case 5:
                        System.out.println("Selecione o tipo de conta da origem:");
                        menuTipoCliente();
                        opcao = ler.nextInt();
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta PF");
                                String conta = ler.nextLine();
                                System.out.println("Digite o valor a ser transferido");
                                double valor = ler.nextDouble();
                                break;
                            case 2:
                                System.out.println("Informe a conta PJ:");
                                conta = ler.nextLine();
                                System.out.println("Digite o valor a ser transferido");
                                valor = ler.nextDouble();
                                break;
                        }
                    case 6:
                        menuTipoCliente();
                        opcao = ler.nextInt();
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta PF:");
                                String conta = ler.nextLine();
                                System.out.println("Informe o valor em R$:");
                                double valor = ler.nextDouble();
                                clearBuffer(ler);
                                adicionaSaldoF(pfs, conta, valor);
                                break;
                            case 2:
                                System.out.println("Informe a conta PJ:");
                                conta = ler.nextLine();
                                System.out.println("Informe o valor em R$:");
                                valor = ler.nextDouble();
                                clearBuffer(ler);
                                adicionaSaldoJ(pjd, conta, valor);
                                break;
                        }
                        break;
                    case 7:
                        // relatorio

                        exibeTodosPessoaF(pfs);
                        exibeTodosPessoaJ(pjd);


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

