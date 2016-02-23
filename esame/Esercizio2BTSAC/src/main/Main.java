package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;

public class Main {

	public static void main(String[] args) {
		
		PressureSensor ps = new PressureSensor();
		
		PressureCallback call = new PressureCallback() {
			
			Set<Double> values;
			Map<Integer, Integer> errors; 
			
			@Override
			public void onSuccess(double pressure) {
				values.add(pressure);
			}
			
			@Override
			public void onFailed(PressureSensorException exception) {
				int count = 0;
				int errorCode = exception.getErrorcode();
				if(errors.containsKey(errorCode)) {
					count = errors.get(errorCode) + 1;
					errors.put(exception.getErrorcode(), count);
				}
				else
					errors.put(exception.getErrorcode(), 1);
			}

			@Override
			public void setValues(Set<Double> values) {
				this.values = values;
			}

			@Override
			public void setErrors(Map<Integer, Integer> errors) {
				this.errors = errors;
				
			}
		};
		
		Set<Double> values = new HashSet<>();
		Map<Integer, Integer> errors = new HashMap<>();
		call.setValues(values);
		call.setErrors(errors);
		
		ps.setListener(call);
		
		for (int i = 0; i < 1000; ++i) {
			ps.next();
		}
		
		System.out.println("temperatura MAX: " + values.stream().max((d1, d2) -> Double.compare(d1, d2)));
		
		System.out.println("media valori: " + values.stream().reduce((acc, d) -> acc + d).get() / values.size());
		
		System.out.println("errori: " + errors.entrySet());
		
	}

}