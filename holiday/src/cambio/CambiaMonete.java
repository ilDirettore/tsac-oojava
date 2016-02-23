package cambio;

import java.util.Scanner;

public class CambiaMonete {

	public CambiaMonete () {
		
		int flagMenu = 0;
		
		do {
			System.out.println("Inserisci un valore intero da cambiare ('0' per terminare l'esecuzione): ");
			
			Scanner input = new Scanner(System.in);
			 int valore =  flagMenu = input.nextInt();
			
			int[] nTagli = new int[9];
			int[] tagli = {500, 200, 100, 50, 20, 10, 5, 2, 1};
			while(valore > 0) {
				if (valore >= 500) {
					nTagli[0]++;
					valore -= 500;
				}
				else if (valore >= 200) {
					nTagli[1]++;
					valore -= 200;
				}
				else if (valore >= 100) {
					nTagli[2]++;
					valore -= 100;
				}
				else if (valore >= 50) {
					nTagli[3]++;
					valore -= 50;
				}
				else if (valore >= 20) {
					nTagli[4]++;
					valore -= 20;
				}
				else if (valore >= 10) {
					nTagli[5]++;
					valore -= 10;
				}
				else if (valore >= 5) {
					nTagli[6]++;
					valore -= 5;
				}
				else if (valore >= 2) {
					nTagli[7]++;
					valore -= 2;
				}
				else if (valore >= 1) {
					nTagli[8]++;
					valore -= 1;
				}
			}
			for(int i = 0; i < nTagli.length; ++i) { // STAMPA
				int nBanconote = nTagli[i];
				if (nBanconote > 0) {
					String borm = "banconot"; // borm sta per: banconote OR monete
					char pors = 'a'; // mentre pors per: plurale OR singolare
					if (i > 6)
						borm = "monet";
					if (nBanconote > 1)
						pors = 'e';
					System.out.println(nBanconote + " " + borm + pors + " da € " + tagli[i]);
				}
			}
			System.out.println("--------------------");
		} while(flagMenu != 0);
	}
}
