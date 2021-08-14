package matematiko.metric;

import kompari.Order;
import kompari.real.DoubleOrder;
import kompari.real.L2HOrder;

public class DistanceOrder<T> implements Order<T>{
	protected Distance<T> distance;
	protected T point;
	protected DoubleOrder order;
	
	public DistanceOrder( Distance<T> distance, T point ){
		this.distance = distance;
		this.point = point;
		this.order = new L2HOrder();
	}

	@Override
	public int compare(T x, T y){ return order.compare(distance.apply(x,point),distance.apply(y,point)); }
}