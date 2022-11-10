/*teste*/
public abstract class Pessoa {
	private String conta;
	private String agencia;
	private String telefone;
	private double saldo;
	private double limite;
	
	public Pessoa(String conta, String agencia, String telefone, double saldo, double limite) {
		super();
		this.conta = conta;
		this.agencia = agencia;
		this.telefone = telefone;
		this.saldo = saldo;
		this.limite = limite;
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
}
