
public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String[] nome = new String[3];
	private String razaoSocial;
	private String nomeFantasia;
	
	
	public PessoaJuridica(String conta, String agencia, String telefone, double saldo, double limite, String cnpj,
			String[] nome, String razaoSocial, String nomeFantasia) {
		super(conta, agencia, telefone, saldo, limite);
		this.cnpj = cnpj;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String[] getNome() {
		return nome;
	}
	public void setNome(String[] nome) {
		this.nome = nome;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
}
