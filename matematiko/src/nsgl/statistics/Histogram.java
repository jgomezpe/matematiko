package nsgl.statistics;

import java.util.Iterator;

import nsgl.generic.array.Sorted;
import nsgl.pair.Pair;
import nsgl.order.Order;
import nsgl.pair.PairAOrder;

public class Histogram<K> {
	protected Sorted<Pair<K, Integer>> array;
		
	public Histogram( Order order ){
		array = new Sorted<Pair<K, Integer>>(new PairAOrder<K,Integer>(order));
	}
	
	public void add( K key, int amount ){
		Pair<K, Integer> pair = new Pair<K, Integer>(key, amount);
		try{
			Integer index = array.find(pair);
			pair = array.get(index);
			pair.setB( pair.b()+amount );
		}catch(Exception e){ array.add(pair); }
	}
	
	public void inc( K key ){ add( key, 1 ); }
	
	public K mode(){
		try{
			int m = 0;
			for( int i=1; i<array.size(); i++ )
				if( array.get(i).b() > array.get(m).b() ) m=i;
			return array.get(m).a();
		}catch(Exception e){ return null; }
	}
	
	public String toString(){
		return array.toString();
	}
	
	public void clear(){ array.clear(); }
	
	public Iterator<K> keys(){ return new HistogramKeys<K>(this); }	
}