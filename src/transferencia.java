
import java.util.Scanner;

public class transferencia {

    public static void transferirDinheiro(PessoaJuridica[] pjd, PessoaFisica[] pfs, Scanner ler, boolean origem, boolean destino) {
        double valor;
        boolean sucessoJ = false;
        boolean sucessoF = false;
        if (origem) {
            System.out.println("Digite o numero da conta PF:");
            String contaOrigem = ler.nextLine();
            System.out.println("Digite o valor a ser transferido");
            valor = ler.nextDouble();
            Controla.clearBuffer(ler);
            sucessoF = transfereDinheiroFOrigem(pfs, contaOrigem, valor);

        } else {
            System.out.println("Digite o numero da conta PJ:");
            String contaOrigem = ler.nextLine();
            System.out.println("Digite o valor a ser transferido");
            valor = ler.nextDouble();
            Controla.clearBuffer(ler);
            sucessoJ = transfereDinheiroJOrigem(pjd, contaOrigem, valor);
        }
        if (destino) {
            if (sucessoJ || sucessoF) {
                System.out.println("Digite o numero da conta de destino PF:");
                String contaDestino = ler.nextLine();
                destinoPF(pfs, contaDestino, valor);
            }

        } else {
            if (sucessoJ || sucessoF) {
                System.out.println("Digite o numero da conta de destino PJ:");
                String contaDestino = ler.nextLine();
                destinoPJ(pjd, contaDestino, valor);
            }

        }



    }

    public static boolean transfereDinheiroFOrigem(PessoaFisica[] pfs, String contaOrigem, double valor) {
        boolean contaInvalida = false;

        for (int i = 0; i < pfs.length; i++) {
            if (pfs[i] != null && pfs[i].getConta().equals(contaOrigem)) {
                if (pfs[i].getSaldo() + pfs[i].getLimite() >= valor) {
                    pfs[i].setSaldo(pfs[i].getSaldo() - valor);
                    contaInvalida = true;
                    return true;


                } else if (pfs[i].getSaldo() + pfs[i].getLimite() < valor) {
                    System.out.println("Saldo insuficiente!");
                    contaInvalida = true;
                    return false;

                }
            }
        } if (!contaInvalida) {
            System.out.println("Conta não encontrada!");
        }
        return false;
    }




    public static boolean transfereDinheiroJOrigem(PessoaJuridica[] pjd, String contaOrigem, double valor) {
        boolean contaInvalida = false;

        for (int i = 0; i < pjd.length; i++) {
            if (pjd[i] != null && pjd[i].getConta().equals(contaOrigem)) {
                if (pjd[i].getSaldo() + pjd[i].getLimite() >= valor) {
                    pjd[i].setSaldo(pjd[i].getSaldo() - valor);
                    contaInvalida = true;

                    break;
                } else if (pjd[i].getSaldo() + pjd[i].getLimite() < valor) {
                    System.out.println("Saldo insuficiente!");
                } else {
                    System.out.println("Pessoa nao cadastrada!");

                }
            }
        }

        return contaInvalida;
    }

    public static void destinoPF(PessoaFisica[] pfs, String contaDestino, double valor){
        boolean contaInvalida = false;
        for (int j = 0; j < pfs.length; j++) {
            if (pfs[j] != null && pfs[j].getConta().equals(contaDestino)) {
                pfs[j].setSaldo(pfs[j].getSaldo() + valor);
                contaInvalida = true;
                System.out.println("Saldo adicionado!");
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }


    }

    public static void destinoPJ(PessoaJuridica[] pjd, String contaDestino, double valor) {
        boolean contaInvalida = false;
        for (PessoaJuridica pessoaJuridica : pjd) {
            if (pessoaJuridica != null && pessoaJuridica.getConta().equals(contaDestino)) {
                pessoaJuridica.setSaldo(pessoaJuridica.getSaldo() + valor);
                contaInvalida = true;
                System.out.println("Saldo adicionado!");
                break;
            }
        }
        if (!contaInvalida) {
            System.out.println("Pessoa nao cadastrada!");
        }
    }
}
