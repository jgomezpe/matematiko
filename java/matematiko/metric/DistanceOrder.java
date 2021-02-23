package matematiko.metric;

import kompari.real.L2HOrder;
import kompari.real.Order;

public class DistanceOrder<T> implements kompari.Order{
	protected Distance<T> distance;
	protected T point;
	protected Order order;
	
	public DistanceOrder( Distance<T> distance, T point ){
		this.distance = distance;
		this.point = point;
		this.order = new L2HOrder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compare(Object x, Object y){ return ((Double)distance.apply((T)x,point)).compareTo(distance.apply((T)y,point)); }
}