package maranta.harbourTest;

import static org.junit.Assert.*;

import org.junit.Test;

import maranta.harbour.*;

public class Simulazione {

	@Test
	public void test() {
			Gioco game = new Gioco();
			game.getPorto().setMq(1000);
			
			Sottomarino uboat = new Sottomarino();
			uboat.setnArmamenti(1);
			uboat.setStazza(1);
			
			Aereo zeroF = new Aereo();
			zeroF.setnArmamenti_A(1);
			zeroF.setnArmamenti_B(1);
			
			Invasore[] gruppo = {uboat, zeroF};
			
			game.attacco(gruppo);
			
			assertEquals(19, game.getnAttacchi());
			System.out.println("numero d attacchi subiti prima di essere distrutto: " + game.getnAttacchi());
	}

}
