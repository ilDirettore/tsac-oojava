package cambio2;

public class MoneyChange {
	
	private Money[] change;
	
	MoneyChange(int[] tagli) {
		change = new Money[tagli.length];
		int i = 0;
		for (int x : tagli) {
			change[i] = new Money(x);
			i++;
		}
	}
	
	void setChange(int importo) {
		int i = 0;
		while(importo > 0) {
			change[i].setN(importo / change[i].getTaglio());
			importo -= change[i].getN() * change[i].getTaglio();
			i++;
		}
	}
	
	Money[] getChange() {
		int i = 0;
		for(Money x : change) {
			if (x.getN() > 0)
				i++;
		}
		Money[] changeNew = new Money[i];
		
		i = 0;
		for(Money x : change) {
			if (x.getN() > 0) {
				changeNew[i] = x;
				i++;
			}
		}
		return changeNew;
	}

}
