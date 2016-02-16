package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Gioco {
	
	private AeroPorto p;

	public Gioco(AeroPorto p) {
		this.p = p;
	}

	public void attacco(Potenza[] invasoriA) {
		double sum = 0;
		for(Potenza invasore : invasoriA) {
			sum += invasore.potenzaFuoco();
		}
		sum *= 2.5;
		p.addMetriQuadriDistrutti(sum);
	}

	public boolean portoDistrutto() {
		return (p.getDimensioneSqMetersNonDistrutta()> 0) ?false :true;
	}

}
