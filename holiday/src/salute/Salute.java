package salute;

public class Salute {
	
	public static double metabolismo(Persona pers) {
		double mb = 655 + (1.8 * pers.getAltezza()) - (4.7 * pers.getEta());
		if (pers.getSesso() == 'm') {
			mb += (13.8 * pers.getPeso());
		}
		else {
			mb += (9.6 * pers.getPeso());
		}
		switch (pers.getAttivita()) {
			case "sedentario":
				mb += (mb * 20 / 100);
				break;
			case "moderatamente attivo":
				mb += (mb * 30 / 100);
				break;
			case "attivo":
				mb += (mb * 40 / 100);
				break;
			case "molto attivo":
				mb += (mb * 50 / 100);
				break;
		}
		return mb;
	}
	
	public static void print_classeRischio(Persona pers) {
		System.out.print("Classe di rischio: " );
		double IMC = pers.getIMC();
		if (IMC < 18.5)
			System.out.println("sottopeso");
		else if (IMC < 25)
			System.out.println("normale");
		else if (IMC < 30)
			System.out.println("sovrappeso");
		else
			System.out.println("obbeso");
	}

}
