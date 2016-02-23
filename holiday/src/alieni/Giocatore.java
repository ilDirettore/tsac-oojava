package alieni;

public class Giocatore {
	
	private String nome;
	private int salute;
	
	public Giocatore(String nome) {
		this.nome = nome;
		salute = 100;
	}
	
	public int getSalute() {
		return salute;
	}
	
	public void setSalute(int newSalute) {
		salute = newSalute;
	}

}
