
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContaCorrente cc = new ContaCorrente(354, 756, "Fulano de Tal", "12345678900", 1234, 123456, 250.0, 500.0);
		
		CaixaEletronico caixa = new CaixaEletronico(cc);
		
	    caixa.execSaque();
	
	}

}
