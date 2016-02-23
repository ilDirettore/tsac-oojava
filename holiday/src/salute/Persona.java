package salute;

public class Persona {
	
	private int altezza;
	private int peso;
	private int eta;
	private String attivitaFisica;
	private char sesso;
	private double IMC;
	
	public Persona(int altezza, int peso, int eta, String attivitaFisica, char sesso) {
		this.altezza = altezza;
		this.peso = peso;
		this.eta = eta;
		this.attivitaFisica = attivitaFisica;
		this.sesso = sesso;
		IMC = (double)altezza / 100;
		IMC = Math.pow(IMC, 2);
		IMC = peso / IMC;
	}
	
	public int getAltezza() {
		return altezza;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public int getEta() {
		return eta;
	}
	
	public String getAttivita() {
		return attivitaFisica;
	}
	
	public char getSesso() {
		return sesso;
	}
	public double getIMC() {
		return IMC;
	}

}
