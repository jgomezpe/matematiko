package nsgl.real;

import nsgl.metric.Distance;

public class Abs implements Distance<Double>{
	@Override
	public double apply(Double x, Double y) {
		// TODO Auto-generated method stub
		return Math.abs(x-y);
	}

}
