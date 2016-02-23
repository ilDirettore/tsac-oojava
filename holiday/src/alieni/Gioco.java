package alieni;

public class Gioco {
	
	private Giocatore player;
	
	public Gioco(Giocatore player) {
		this.player = player;
	}
	
	public void fight(Alieno[] gruppo) {
		int danno = 0;
		for(Alieno x : gruppo) {
			danno += x.getDanno(); 
		}
		player.setSalute(player.getSalute() - danno);
	}
	
	public boolean vivo() {
		return player.getSalute() > 0;
	}

}
