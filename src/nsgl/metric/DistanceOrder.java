package nsgl.metric;

public class DistanceOrder<T> implements nsgl.order.Order{
	protected Distance<T> distance;
	protected T point;
	protected nsgl.real.Order order;
	
	public DistanceOrder( Distance<T> distance, T point ){
		this.distance = distance;
		this.point = point;
		this.order = new nsgl.real.L2HOrder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compare(Object x, Object y){ return ((Double)distance.apply((T)x,point)).compareTo(distance.apply((T)y,point)); }
}