import java.util.Scanner;
import java.util.InputMismatchException;
public class CaixaEletronico {
	private int erros_pin_quatro;
	private int erros_pin_seis;
	private int opcao_desejada;
	ContaCorrente cc;
	Scanner input= new Scanner(System.in);
	//ContaCorrente cc = new ContaCorrente(564, 95646, "Fulano", "15429149730", 1234, 123456, 500.0, 1000.0);
	

	public boolean validaOperacao(int pin_fornecido) {
		
		if (cc.pin_quatro== pin_fornecido) {
			return true;
				}
			else {
				return false;}
		
	}

	public boolean validaAcesso(int pin_fornecido) {
			if (cc.pin_seis== pin_fornecido) {
				return true;
				}
				
				else {
					return false;}
	}

	
	public void alteraLimite() {
		
		
		while (this.erros_pin_quatro < 3) {
			System.out.println("\nEnsira sua senha de 4 digitos");
			int senha_digitada = input.nextInt();
			boolean _tmp = validaOperacao(senha_digitada);
			if (_tmp == true) {
				this.cc.limite *= 1.1;
				System.out.println("\nNovo limite: " + this.cc.limite);
				break;
			}
			else {
				System.out.println("\nSenha incorreta");
				this.erros_pin_quatro +=1;
			}
		}
	
	}
	
	

	    public boolean ValidaCPF(String CPF) {
	        if (CPF.equals("00000000000") ||
	            CPF.equals("11111111111") ||
	            CPF.equals("22222222222") || CPF.equals("33333333333") ||
	            CPF.equals("44444444444") || CPF.equals("55555555555") ||
	            CPF.equals("66666666666") || CPF.equals("77777777777") ||
	            CPF.equals("88888888888") || CPF.equals("99999999999") ||
	            (CPF.length() != 11))
	            return(false);

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        try {
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); 

	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);


	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }
	
	public void getExtratoBancario() {		
		while (this.erros_pin_quatro < 3) {
			System.out.println("\nDigite sua senha de 4 digitos");
			int senha_digitada = input.nextInt();
			boolean _tmp = validaOperacao(senha_digitada);
			
			if (_tmp == true) {
				System.out.println("\nSaldo: " + this.cc.saldo);
				break;
			}
			else {
				System.out.println("\nSenha incorreta");
				this.erros_pin_quatro +=1;
			}
		}
	}
	
	public void pixCPF() {
		
		System.out.println("\nInsira um CPF: ");
		String _cpf = input.next();
		boolean _tmp2= ValidaCPF(_cpf);
		
		if (_tmp2 == true) {
			
			while (this.erros_pin_quatro <3) {
					System.out.println("\nInsira o valor da transferencia pix: ");
					double _valor = input.nextDouble();
		
					if (this.cc.saldo >=  _valor) {
					
					System.out.println("\nInsira sua Senha de 4 digitos: ");
					int senha_digitada = input.nextInt();
					boolean _tmp = validaOperacao(senha_digitada);
					
					if (_tmp == true) {
					this.cc.saldo -= _valor;
						break;
					}
					else {
						System.out.println("\nSenha incorreta");
						this.erros_pin_quatro += 1;
	
					}
				
				}
				else {
						System.out.println("\nSaldo insuficiente.");
						break;
				}
			}
		}

		
		else {
			System.out.println("CPF invalido");
		}
	}
	
	public CaixaEletronico (ContaCorrente cc) {
		this.cc = cc;
	}
	
	public void execSaque() {
		System.out.println("Digite o quanto quer sacar :");
		double saque = input.nextDouble();
		
		if(saque > this.cc.getSaldo()) {
			System.out.println("Saldo insuficiente, você tem: " + this.cc.getSaldo());
		}
		else {
			double transacao = this.cc.getSaldo() - saque;
			this.cc.setSaldo(transacao);
		}
	}
	
	public void execDeposito() {
		System.out.println("Digite o quanto quer depositar :");
		double deposito = input.nextDouble();
		double saldoTotal = deposito + this.cc.getSaldo();
		this.cc.setSaldo(saldoTotal);
	}
	
	public void execCaixaEletronico(){
		cc.printInfoConta();
		loop: while (this.erros_pin_seis <3){
		System.out.println("\nInsira sua senha de 6 digitos");
		int senha_6 = input.nextInt();
		if (senha_6 == this.cc.pin_seis) {
			while (true) {
			System.out.println("\nSelecione uma opção:");
			System.out.println("1: Extrato Bancario");
			System.out.println("2: Saque");
			System.out.println("3: Transferencia PixCPF");
			System.out.println("4: Deposito");
			System.out.println("5: Mudança de Limite");
			System.out.println("0: Ecerrar Sessão\n");
			int opcao = input.nextInt();
			switch (opcao) { 
			case 0: 
				System.out.println("\nTchau!");break loop;
			case 1: 
				getExtratoBancario();break;
			case 2:
				
			case 3:
				pixCPF();break;
			case 4:
				
			case 5:alteraLimite();break;
			
			default: System.out.println("\nOpção invalida");break;
			}
		}}
		else {
			System.out.println("\nSenha incorreta");
			this.erros_pin_seis += 1;
			if(this.erros_pin_seis == 3) {
				System.out.println("\nDevido ao numero excessivo de tentativas sua sessão será encerrada.");
			}
		}
		
		}
	}
}

