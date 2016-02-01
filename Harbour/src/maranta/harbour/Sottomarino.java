package maranta.harbour;

public class Sottomarino extends Invasore implements PotenzaFuoco{
	
	private int nArmamenti;
	private int stazza;
	public int getnArmamenti() {
		return nArmamenti;
	}
	public void setnArmamenti(int nArmamenti) {
		this.nArmamenti = nArmamenti;
	}
	public int getStazza() {
		return stazza;
	}
	public void setStazza(int stazza) {
		this.stazza = stazza;
	}
	@Override
	public int getPotenza() {
		return nArmamenti * stazza;
	}

}
