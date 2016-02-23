package maranta.dario.azienda;

import java.util.ArrayList;

public class Azienda {
	
	private String ragioneSociale;
	private Dipendente[] dipendenti = new Dipendente[50];
	private int index = 0;
	
	Azienda() {
		
	}
	
	public Azienda(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	
	public void addDipendente(Dipendente dipendente) {
		dipendenti[index++] = dipendente;
	}
	
	public int sommaStipendi() {
		int somma = 0;
		for (int i = 0; i < index; i++) {
			somma += dipendenti[i].calcoloStipendio();
		}
		return somma;
	}
	
	private double trovaMAX() {
		double max = 0;
		for (int i = 0; i < index; i++) {
			max = Math.max(max, dipendenti[i].calcoloStipendio());
		}
		return max;
	}
	
	public Dipendente[] dipendentiMaxStipendi() {
		double max = trovaMAX();
		ArrayList listaDipendenti = new ArrayList();
		for (int i = 0; i < index; i++) {
			if (dipendenti[i].calcoloStipendio() == max) {
				listaDipendenti.add(dipendenti[i]);
			}
		}
		return (Dipendente[]) listaDipendenti.toArray();
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Dipendente[] getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Dipendente[] dipendenti) {
		this.dipendenti = dipendenti;
	}
}
