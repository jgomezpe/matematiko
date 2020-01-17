package nsgl.statistics;

import java.util.Iterator;

import nsgl.pair.Pair;


public class HistogramKeys<K> implements Iterator<K>{
	protected Iterator<Pair<K,Integer>> iterator;

	public HistogramKeys( Histogram<K> histogram) {
		this.iterator = histogram.array.iterator();
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public K next() {
		return iterator.next().a();
	}
}