
public class PessoaFisica extends Pessoa {
    private String cpf;
    private String nome;
    private int idade;

    public PessoaFisica(String conta, String agencia, String telefone, double saldo, double limite, String cpf,
                        String nome, int idade) {
        super(conta, agencia, telefone, saldo, limite);
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public void consultaPessoaF() {
        System.out.println("Conta: " + getConta());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Limite: " + getLimite());
        System.out.println("CPF: " + getCpf());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        if (getValor() > 0) {
            System.out.println("Valor do empréstimo: R$ " + getValor());
            System.out.println("Taxa de juros: " + (getJuros() * 100) + "% a.m");
            System.out.println("Numero de parcelas: " + getParcelas());
            System.out.println("Total do contrato: R$ " + (getValor() + (getValor() * getJuros() * getParcelas())));
        }
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


}
