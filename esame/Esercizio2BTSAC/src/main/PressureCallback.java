package main;

import java.util.Map;
import java.util.Set;

public interface PressureCallback extends PressureSensorListener {
	
	void setValues(Set<Double> values);
	
	void setErrors(Map<Integer, Integer> errors);
}
