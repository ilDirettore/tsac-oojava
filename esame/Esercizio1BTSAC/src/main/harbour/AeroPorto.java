package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class AeroPorto {
	
	private double dimensioneSqMeters;
	private double MetriQuadriDistrutti;

	public void setDimensioneSqMeters(double sqM) {
		dimensioneSqMeters = sqM;
		
	}

	public double getDimensioneSqMeters() {
		return dimensioneSqMeters;
	}

	public void addMetriQuadriDistrutti(double sqM_distrutti) {
		MetriQuadriDistrutti += sqM_distrutti;
		
	}

	public double getDimensioneSqMetersNonDistrutta() {
		return (MetriQuadriDistrutti > dimensioneSqMeters) ?0 :dimensioneSqMeters - MetriQuadriDistrutti; 
	}

}
