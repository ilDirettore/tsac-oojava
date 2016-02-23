package cambio2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] tagliItalia = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		MoneyChange cambio = new MoneyChange(tagliItalia);
		cambio.setChange(1989);
		Money[] array = cambio.getChange();
		for (Money x : array) {
			System.out.println(x.toString());
		}

	}

}
