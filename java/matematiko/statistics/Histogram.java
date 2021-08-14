package matematiko.statistics;

import java.util.TreeMap;

public class Histogram<K> {
    protected TreeMap<K, Integer> map = new TreeMap<K, Integer>();
		
    public Histogram(){}
	
    public void add( K key, int amount ){
	Integer current = map.get(key);
	current = current!=null?current+amount:amount;
	map.put(key, current);
    }
	
    public void inc( K key ){ add( key, 1 ); }
	
    public void dec( K key ){ add( key, -1 ); }
	
    public K mode(){
	K m = null;
	int min=Integer.MIN_VALUE;
	int v;
	for(K key:map.keySet()) {
	    v = map.get(key);
	    if(v>min) {
		min = v;
		m = key;
	    }	 
	}
	return m;
    }
	
    public void clear(){ map.clear(); }
	
    public Iterable<K> keys(){ return map.keySet(); }	
}