public class ContaCorrente {
	private int agencia;
	private int conta;
	protected int pin_quatro;
	protected int pin_seis;
	private String nome;
	private String cpf;
	protected double saldo;
	protected double limite;
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public double getLimite() {
		return this.limite;
	}
	
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public int get_Conta() {
		return this.conta;
	}
	
	public int get_Agencia() {
		return this.agencia;
	}
	
	public void printInfoConta() {
		System.out.println("Agencia: " + this.agencia + "\nConta: " + this.conta + "\nNome: " + this.nome + "\nCPF: " + this.cpf);
		System.out.println("Saldo: " + this.saldo + ", \nLimite: " + this.limite);
	}
	
	public ContaCorrente(int agencia, int conta, String nome, String cpf, int pin_quatro, int pin_seis, double saldo, double limite) {
	this.agencia = agencia;
	this.conta = conta;
	this.nome = nome;
	this.cpf = cpf;
	this.pin_quatro = pin_quatro;
	this.pin_seis = pin_seis;
	
	
	this.saldo = saldo;
	this.limite = limite;
	}
}
