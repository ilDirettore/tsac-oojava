package cambio2;

public class Money {
	
	private String tipo;
	private int taglio;
	private int n;
	
	
	public Money(int taglio) {
		super();
		this.taglio = taglio;
	}
	
	public void setN(int n) {
		this.n = n;
	}

	public String getTipo() {
		switch(taglio) {
			case 500:
			case 200:
			case 100:
			case 50:
			case 20:
			case 10:
			case 5:
				tipo = "banconot";
				break;
			case 2:
			case 1:
				tipo = "monet";
				break;
			
		}
		tipo += (n > 1) ?"e" :"a";
		if (n == 0)
			return "";
		else
			return tipo;
	}
	public int getTaglio() {
		return taglio;
	}
	public int getN() {
		return n;
	}

	@Override
	public String toString() {
		if (n > 0)
			return n + " " + getTipo() + " da: " + taglio + " €";
		else
			return "";
	}
	
	

}
