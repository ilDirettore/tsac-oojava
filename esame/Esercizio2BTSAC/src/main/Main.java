package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
		
		Iterator<Double> it = values.iterator();
		double max = 0;
		
		while(it.hasNext()) {
			double corrente = it.next();
			if (corrente > max)
				max = corrente; 
		}
		
		System.out.println("temperatura MAX: " + max);
		
		it = values.iterator();
		double sum = 0;
		while(it.hasNext()) {
			sum += it.next();
		}
		double avg = sum / values.size();
		System.out.println("media valori: " + avg);
		
		System.out.println("errori: " + errors.entrySet());
		
	}

}
