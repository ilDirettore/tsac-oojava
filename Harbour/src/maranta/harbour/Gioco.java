package maranta.harbour;

public class Gioco {
	
	private int nAttacchi = 0;
	private double cF = 1.5;
	
	PortoNavale porto = new PortoNavale();

	public PortoNavale getPorto() {
		return porto;
	}

	public void setPorto(PortoNavale porto) {
		this.porto = porto;
	}
	
	public void attacco(Invasore[] gruppo) {
		while(!isDistrutto()) {
			for (Invasore inv : gruppo) {
				if (inv instanceof PotenzaFuoco) {
					double mq = porto.getMq();
					porto.setMq(mq - ((PotenzaFuoco) inv).getPotenza() * cF);
				}
			}
			nAttacchi++;
		}
	}
	
	public int getnAttacchi() {
		return (isDistrutto()) ?nAttacchi :0;
	}

	public boolean isDistrutto() {
		return porto.getMq() <= 0;
	}

}
