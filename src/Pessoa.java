/*teste*/

public abstract class Pessoa {
    private String conta;
    private String agencia;
    private String telefone;
    private double saldo;
    private double limite;

    private boolean temEmprestimo;
    private double valEmprestimo;
    private double juros;
    private int parcelas;

    public Pessoa(String conta, String agencia, String telefone, double saldo, double limite) {
        super();
        this.conta = conta;
        this.agencia = agencia;
        this.telefone = telefone;
        this.saldo = saldo;
        this.limite = limite;
        this.temEmprestimo = false;
        this.valEmprestimo = 0;
        this.juros = 0;
        this.parcelas = 0;
    }


    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void contratar(double valor, double juros, int parcelas) {
        this.valEmprestimo = valor;
        this.juros = juros;
        this.parcelas = parcelas;

        double valorTotal = (valor + (valor * (juros * parcelas)));
    }

    public double getValor() {return valEmprestimo;}

    public double getJuros() {return juros;}

    public int getParcelas() {return parcelas;}
}
