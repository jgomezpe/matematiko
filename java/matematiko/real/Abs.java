package matematiko.real;

import matematiko.metric.Distance;

public class Abs implements Distance<Double>{
	@Override
	public double apply(Double x, Double y) {
		return Math.abs(x-y);
	}

}
