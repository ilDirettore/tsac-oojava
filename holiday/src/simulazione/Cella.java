package simulazione;

import java.util.Random;

public class Cella {
	
	Predatore predatore;
	Preda preda;
	static int MAXpredatori = 10;
	static int MAXprede = 10;
	
	
	Cella() {
		Random rand = new Random();
		if (Predatore.get_nPredatori() < MAXpredatori && Preda.nPrede < MAXprede) {
			switch(rand.nextInt(10)) {
				case 1:
					predatore = new Predatore();
					break;
				case 2:
					preda = new Preda(false);
					break;
			}
		}
		else if(Preda.nPrede < MAXprede) {
			switch(rand.nextInt(2)) {
			case 1:
				preda = new Preda(false);
				break;
			}
		}
		else if(Predatore.get_nPredatori() < MAXpredatori) {
			switch(rand.nextInt(2)) {
			case 1:
				predatore = new Predatore();
				break;
			}
		}
	}
	
	String whatIS() {
		if (predatore == null && preda == null)
			return "vuota";
		else if(predatore != null)
			return "predatore";
		else
			return "preda";
	}
	
	String stampaStato() {
		if(this.whatIS() == "vuota")
			return " ";
		else if(predatore != null)
			return "x";
		else
			return "o";
	}

	public void caccia(int i, int j, Cella[][] griglia) {
		if (predatore != null)
			predatore.azione(i, j, griglia);		
	}

	public void scappa(int i, int j, Cella[][] griglia) {
		if (preda != null)
			preda.azione(i, j, griglia);
		
	}
}
