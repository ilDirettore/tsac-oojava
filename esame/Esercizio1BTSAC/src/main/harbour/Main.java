package main.harbour;

import java.util.Random;


/**
* NON MODIFICARE
*/
public class Main {

	private static void testA(){
		
		Random rand = new Random(1008);
		int totaleCarroarmato = 0;	
		for(int i = 0; i < 1000; ++i) {
			CarroArmato s = new CarroArmato();
			s.setId("s" + i);
			s.setModello("fighter");
			s.setStazza(rand.nextInt(10));
			s.setMissili(rand.nextInt(10));
			totaleCarroarmato += s.potenzaFuoco();
		}
		
		int totaleUBoot = 0;	
		for(int i = 0; i < 1000; ++i) {
			UBoot a = new UBoot();
			a.setId("a" + i);
			a.setModello("falker");
			a.setArmaK(rand.nextInt(10));
			a.setArmaH(rand.nextInt(10));
			totaleUBoot += a.potenzaFuoco();
		}
		
		AeroPorto porto = new AeroPorto();
		porto.setDimensioneSqMeters(rand.nextInt(100000));
		for(int i = 0; i < 1000; ++i) {
			porto.addMetriQuadriDistrutti(rand.nextInt(10));
		}
		
		System.out.println("Potenza fuoco Carroarmato: " + totaleCarroarmato);
		System.out.println("Potenza fuoco UBoot: " + totaleUBoot);
		System.out.println("Porto dimensione non distrutta: " + porto.getDimensioneSqMetersNonDistrutta());
		
	}
	
	private static void testB(){	
		Random rand = new Random(3008);
			
		int counter = 1000; 
		Potenza[] invasori = new Potenza[counter];
		
		AeroPorto porto = new AeroPorto();
		porto.setDimensioneSqMeters(1000000);
		
		for(int i = 0; i < counter; ++i) {
			if (rand.nextInt() % 2 == 0) {
				CarroArmato s = new CarroArmato();
				s.setId("s" + i);
				s.setModello("fighter");
				s.setStazza(rand.nextInt(10));
				s.setMissili(rand.nextInt(10));
				invasori[i] = s;
			} else {
				UBoot a = new UBoot();
				a.setId("a" + i);
				a.setModello("falker");
				a.setArmaK(rand.nextInt(10));
				a.setArmaH(rand.nextInt(10));
				invasori[i] = a;
			}
		}
		
		Gioco gioco = new Gioco(porto);
		gioco.attacco(invasori);
		
		System.out.println("Porto distrutto? " + gioco.portoDistrutto());
		System.out.println("Porto dimensione non distrutta su Gioco: " + porto.getDimensioneSqMetersNonDistrutta());
		
	}
	
	public static void main(String[] args) {
		testA();
		testB();		
	}

}
