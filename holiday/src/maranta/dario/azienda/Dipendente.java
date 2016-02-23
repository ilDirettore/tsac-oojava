package maranta.dario.azienda;

public class Dipendente {
	
	private String nome;
	private String cognome;
	private int anzianita;
	private Contratto contratto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getAnzianita() {
		return anzianita;
	}
	public void setAnzianita(int anzianita) {
		this.anzianita = anzianita;
	}
	public Contratto getContratto() {
		return contratto;
	}
	public void setContratto(Contratto contratto) {
		this.contratto = contratto;
	}
	
	public int calcoloStipendio () {
		double stipendio = contratto.getStipendioBase();
		stipendio += (stipendio * (0.5 * anzianita)) / 100;
		return (int) stipendio;
	}
	
}
