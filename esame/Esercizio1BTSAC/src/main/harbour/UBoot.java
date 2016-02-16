package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class UBoot extends Invasore implements Potenza{

	private int armaK;
	private int armaH;
	
	public void setArmaK(int armaK) {
		this.armaK = armaK;
	}

	public void setArmaH(int armaH) {
		this.armaH = armaH;
	}

	@Override
	public int potenzaFuoco() {
		return armaK * 20 + armaH * 30;
	}
	
}