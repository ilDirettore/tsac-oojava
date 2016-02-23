package simulazione;

import java.util.Random;

public class Preda {
	
	static int nPrede = 0;
	static int predeUccise = 0;
	boolean turno = false;
	private int nPassi = 0;
	
	Preda(boolean turno) {
		this.turno = turno;
		nPrede++;
	}
	
	void azione(int i, int j, Cella[][] griglia) {
		if (!turno) {
			nPassi++;
			int riga = i;
			int colonna = j;
			Random rand = new Random();
			switch(rand.nextInt(4)) {
				case 0: // muovi in alto
					riga = i - 1;
					break;
				case 1: // muovi a destra
					colonna = j + 1;
					break;
				case 2: // muovi in basso
					riga = i + 1;
					break;
				case 3: // muovi a sinistra
					colonna = j - 1;
					break;
			}
			if (cellaVuota(riga, colonna, griglia)) {
				griglia[riga][colonna].preda = this;
				griglia[i][j].preda = null;
				turno = true;
			}
			else {
				riga = i;
				colonna = j;
			}
			if (nPassi == 3) {
				generazione(riga, colonna, griglia);
				nPassi = 0;
			}
		}
	}
	
	private void generazione(int riga, int colonna, Cella[][] griglia) {
		if(cellaVuota(riga + 1, colonna, griglia)) {
			griglia[riga + 1][colonna].preda = new Preda(true);
		}
		else if(cellaVuota(riga - 1, colonna, griglia)) {
			griglia[riga - 1][colonna].preda = new Preda(true);
		}
		else if(cellaVuota(riga, colonna + 1, griglia)) {
			griglia[riga][colonna + 1].preda = new Preda(true);
		}
		else if(cellaVuota(riga, colonna - 1, griglia)) {
			griglia[riga][colonna - 1].preda = new Preda(true);
		}
	}
	
	private boolean range(int a) {
		return (a >= 0 && a <= 19);
	}
	
	private boolean cellaVuota(int riga, int colonna, Cella[][] griglia) {
		return (range(riga) && range(colonna)) && griglia[riga][colonna].whatIS() == "vuota";
	}
	
	static int get_nPrede() {
		return nPrede;
	}
	
	static int get_predeUccise() {
		return predeUccise;
	}

}
