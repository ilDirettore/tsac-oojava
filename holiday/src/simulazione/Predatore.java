package simulazione;

import java.util.Random;

public class Predatore {
	
	int nPassi = 0;
	boolean turno = false;
	private boolean stomacoPieno = false;
	private static int nPredatori = 0;
	
	Predatore() {
		nPredatori++;
	}
	
	Predatore(boolean turno) {
		nPredatori++;
		this.turno = turno;
	}
	
	void azione(int i, int j, Cella[][] griglia) {
		if (!turno) {
			turno = true;
			if(!mangia(i, j, griglia)) {
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
					griglia[riga][colonna].predatore = this;
					griglia[i][j].predatore = null;
				}
				else {
					riga = i;
					colonna = j;
				}
				if (nPassi == 8 && stomacoPieno) {
					generazione(riga, colonna, griglia);
					nPassi = 0;
					stomacoPieno = false;
				}
				else if (nPassi == 8){
					griglia[riga][colonna].predatore = null;
					Predatore.nPredatori--;
				}
		}
		}
}
	
	private boolean mangia(int riga, int colonna, Cella[][] griglia) {
		if(cellaPreda(riga + 1, colonna, griglia)) {
			griglia[riga + 1][colonna].preda = null;
			griglia[riga + 1][colonna].predatore = this;
			griglia[riga][colonna].predatore = null;
			return subMangia();
		}
		else if(cellaPreda(riga - 1, colonna, griglia)) {
			griglia[riga - 1][colonna].preda = null;
			griglia[riga - 1][colonna].predatore = this;
			griglia[riga][colonna].predatore = null;
			return subMangia();
		}
		else if(cellaPreda(riga, colonna + 1, griglia)) {
			griglia[riga][colonna + 1].preda = null;
			griglia[riga][colonna + 1].predatore = this;
			griglia[riga][colonna].predatore = null;
			return subMangia();
		}
		else if(cellaPreda(riga, colonna - 1, griglia)) {
			griglia[riga][colonna - 1].preda = null;
			griglia[riga][colonna - 1].predatore = this;
			griglia[riga][colonna].predatore = null;
			return subMangia();
		}
		else
			return false;
	}
	
	private boolean subMangia() {
		stomacoPieno = true;
		Preda.nPrede--;
		Preda.predeUccise++;
		return true;
	}
	
	private boolean range(int a) {
		return (a >= 0 && a <= 19);
	}
	
	private boolean cellaPreda(int riga, int colonna, Cella[][] griglia) {
		return (range(riga) && range(colonna)) && griglia[riga][colonna].whatIS() == "preda";
	}
	
	private boolean cellaVuota(int riga, int colonna, Cella[][] griglia) {
		return (range(riga) && range(colonna)) && griglia[riga][colonna].whatIS() == "vuota";
	}
	
	private void generazione(int riga, int colonna, Cella[][] griglia) {
		if(cellaVuota(riga + 1, colonna, griglia)) {
			griglia[riga + 1][colonna].predatore = new Predatore(true);
		}
		else if(cellaVuota(riga - 1, colonna, griglia)) {
			griglia[riga - 1][colonna].predatore = new Predatore(true);
		}
		else if(cellaVuota(riga, colonna + 1, griglia)) {
			griglia[riga][colonna + 1].predatore = new Predatore(true);
		}
		else if(cellaVuota(riga, colonna - 1, griglia)) {
			griglia[riga][colonna - 1].predatore = new Predatore(true);
		}
	}
	
	static int get_nPredatori() {
		return nPredatori;
	}

}
