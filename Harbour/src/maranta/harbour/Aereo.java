package maranta.harbour;

public class Aereo extends Invasore implements PotenzaFuoco {
	
	private int nArmamenti_A;
	private int nArmamenti_B;
	public int getnArmamenti_A() {
		return nArmamenti_A;
	}
	public void setnArmamenti_A(int nArmamenti_A) {
		this.nArmamenti_A = nArmamenti_A;
	}
	public int getnArmamenti_B() {
		return nArmamenti_B;
	}
	public void setnArmamenti_B(int nArmamenti_B) {
		this.nArmamenti_B = nArmamenti_B;
	}
	@Override
	public int getPotenza() {
		return (nArmamenti_A * 10) + (nArmamenti_B * 25);
	}
	
}
