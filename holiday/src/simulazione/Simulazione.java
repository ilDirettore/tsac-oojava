package simulazione;

public class Simulazione {
	
	private Cella[][] griglia = new Cella[20][20];
	
	Simulazione() {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				griglia[i][j] = new Cella();
			}
		}
	}
	
	void statoMondo() {
		System.out.println("numero prede: " + Preda.get_nPrede() + " - numero predatori: " + Predatore.get_nPredatori() + " - prede usccise: "+ Preda.get_predeUccise());
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				System.out.print(griglia[i][j].stampaStato() + " | ");
				if (j == 19) {
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Simulazione sim = new Simulazione();
		System.out.print("CREAZIONE MONDO - ");
		sim.statoMondo();
		int i = 0;
		while(true) {
			sim.passoTemporale(i++ + 1);
		}
	}
	
	void passoDiscreto() {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				if(griglia[i][j].preda != null)
					griglia[i][j].preda.turno = false;
				else if(griglia[i][j].predatore != null)
					griglia[i][j].predatore.turno = false;
			}
		}
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				griglia[i][j].caccia(i, j, griglia);
			}
		}
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				griglia[i][j].scappa(i, j, griglia);
			}
		}
	}
	
	void passoTemporale(int i) throws InterruptedException {
		Thread.sleep(2000);
		passoDiscreto();
		System.out.println();
		System.out.print(i + "^ PT - ");
		statoMondo();
	}

}
