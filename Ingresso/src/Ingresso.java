
public class Ingresso implements TipoIngresso{
	
	private float valor;
	
	public Ingresso(){
		valor = 120;
	}

	@Override
	public void imprimeValor() {
		System.out.println("Ingresso Normal R$ "+valor);
	}
	
	public void imprimeValor(String tipo){
		System.out.println("Ingresso VIP R$ "+(valor+(valor/100)*50));
	}
	
	public static void main(String[] args){
		Ingresso teste = new Ingresso();
		teste.imprimeValor();
		teste.imprimeValor("vip");
	}
}