
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaBanco {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        int cont = 0;
        PessoaFisica[] pfs = new PessoaFisica[50];
        PessoaJuridica[] pjd = new PessoaJuridica[50];
        do {
            Controla.menu();
            try {
                opcao = ler.nextInt();
                Controla.clearBuffer(ler);
                switch (opcao) {
                    case 1:
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                        switch (opcao) {
                            case 1:
                                Controla.dadosPessoaF(ler, cont, pfs);
                                cont++;
                                break;
                            case 2:
                                Controla.dadosPessoaJ(ler, cont, pjd);
                                cont++;
                                break;
                        }
                        break;
                    case 2:
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                        switch (opcao) {
                            case 1 -> {
                                System.out.println("Informe a conta da PF:");
                                String contaF = ler.nextLine();
                                Controla.removePessoaF(pfs, contaF);
                                cont--;
                            }
                            case 2 -> {
                                System.out.println("Informe a conta da PJ:");
                                String contaJ = ler.nextLine();
                                Controla.removePessoaJ(pjd , contaJ);
                                cont--;
                                Controla.adicionaSaldoF(pfs, contaJ, cont);
                            }
                        }
                        break;
                    case 3:
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta:");
                                String conta = ler.nextLine();
                                Controla.pesquisaPessoaF(pfs, conta);
                                break;
                            case 2:
                                System.out.println("Informe a conta:");
                                conta = ler.nextLine();
                                Controla.pesquisaPessoaJ(pjd, conta);
                                break;
                        }
                        break;
                    case 4:
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                           switch (opcao) {
                               case 1:
                                   System.out.println("Informe a conta PF:");
                                   String conta = ler.nextLine();
                                   double limite = 0;
                                   while (limite < 0) {
                                       System.out.println("Informe o novo limite:");
                                        limite = ler.nextDouble();
                                        Controla.clearBuffer(ler);
                                   }
                                   Controla.ajustaLimitePF(pfs, conta, limite);
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
                                   Controla.ajustaLimitePJ(pjd, conta, limite);
                                   break;
                           }
                        break;
                    case 5:
                        System.out.println("Selecione o tipo de conta da origem:");
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta de origem PF");
                                String contaOrigen = ler.nextLine();
                                System.out.println("Digite o valor a ser transferido");
                                double valor = ler.nextDouble();
                                Controla.clearBuffer(ler);
                                System.out.println("Informe a conta de destino PF");
                                String contaDestino = ler.nextLine();
                                Controla.transfereDinheiroF(pfs, contaOrigen, contaDestino, valor);
                                break;
                            case 2:
                                System.out.println("Informe a conta de origem PJ");
                                contaOrigen = ler.nextLine();
                                System.out.println("Digite o valor a ser transferido");
                                valor = ler.nextDouble();
                                Controla.clearBuffer(ler);
                                System.out.println("Informe a conta de destino PJ");
                                contaDestino = ler.nextLine();
                                Controla.transfereDinheiroJ(pjd, contaOrigen, contaDestino, valor);
                                break;
                        }
                        break;
                    case 6:
                        Controla.menuTipoCliente();
                        opcao = ler.nextInt();
                        Controla.clearBuffer(ler);
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe a conta PF:");
                                String conta = ler.nextLine();
                                System.out.println("Informe o valor em R$:");
                                double valor = ler.nextDouble();
                                Controla.clearBuffer(ler);
                                Controla.adicionaSaldoF(pfs, conta, valor);
                                break;
                            case 2:
                                System.out.println("Informe a conta PJ:");
                                conta = ler.nextLine();
                                System.out.println("Informe o valor em R$:");
                                valor = ler.nextDouble();
                                Controla.clearBuffer(ler);
                                Controla.adicionaSaldoJ(pjd, conta, valor);
                                break;
                        }
                        break;
                    case 7:
                        // relatorio
                        System.out.println("Pessoas FISICAS");
                        Controla.exibeTodosPessoaF(pfs);
                        System.out.println("Pessoas JURIDICAS");
                        Controla.exibeTodosPessoaJ(pjd);
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

