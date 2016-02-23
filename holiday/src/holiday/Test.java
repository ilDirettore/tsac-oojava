package holiday;

import java.awt.Toolkit;

import alieni.Alieno;
import alieni.Giocatore;
import alieni.Gioco;
import cambio.CambiaMonete;
import maranta.dario.azienda.Azienda;
import maranta.dario.azienda.Contratto;
import maranta.dario.azienda.Dipendente;
import salute.Persona;
import salute.Salute;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new CambiaMonete();
		
		/*Persona roberta = new Persona(152, 47, 27, "attivo", 'f');
		System.out.println("Metabolismo basale: " + Salute.metabolismo(roberta));
		Salute.print_classeRischio(roberta);
		
		Contratto padre = new Contratto("padre", 1536);
		Contratto madre = new Contratto("madre", 2000);
		Contratto figlio = new Contratto("figlio", 3000);
		
		Azienda myFamily = new Azienda("MARANTA snc");
		
		myFamily.addDipendente(new Dipendente("Eugenio", "Maranta", 65, padre));
		myFamily.addDipendente(new Dipendente("Giuseppina", "Lamponi", 57, madre));
		myFamily.addDipendente(new Dipendente("Davide", "Maranta", 32, figlio));
		myFamily.addDipendente(new Dipendente("Roberta", "Maranta", 27, figlio));
		myFamily.addDipendente(new Dipendente("Dario", "Maranta", 26, figlio));
		
		
		System.out.println("La somma degli stipendi da erogare: " + myFamily.sommaStipendi());
		
		System.out.println("I dipendenti con lo stipendio massimo sono:");
		for(Object x : myFamily.elencoDipendenti()) {
			Dipendente dip = (Dipendente) x;
			System.out.println(dip.getNome() + " " + dip.getCognome());
		}*/
		
		Giocatore dario = new Giocatore("ilDirettore");
		Alieno a1 = new Alieno("Quazel", 10);
		Alieno a2 = new Alieno("Xetron", 20);
		Alieno a3 = new Alieno("Dirvaz", 30);
		Alieno[] gruppoAlieni = {a1, a2, a3};
		Gioco game = new Gioco(dario);
		game.fight(gruppoAlieni);
		System.out.println("il giocatore è: " + (game.vivo()?"vivo":"morto"));
		
	}

}