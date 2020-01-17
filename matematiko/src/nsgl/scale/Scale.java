/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nsgl.scale;

import java.util.Iterator;

import nsgl.generic.array.ArrayInterface;
import nsgl.copy.Copyable;


/**
 *
 * @author jgomez
 */
public interface Scale<T> {
    public T fastApply( T x );
    
    @SuppressWarnings("unchecked")
	default T apply( T x ){ return fastApply((T)Copyable.cast(x).copy()); }
    
    default ArrayInterface<T> apply( ArrayInterface<T> a ){
        ArrayInterface<T> v = a.instance(a.size());
        int i=0;
        Iterator<T> iter = a.iterator();
        while( iter.hasNext() ) v.set(i++,apply(iter.next()));
        return v;
    }
    
    default ArrayInterface<T> fastApply( ArrayInterface<T> a ){
    	try{ for( int i=0; i<a.size(); i++ ) a.set(i, fastApply(a.get(i))); }catch(Exception e){}
    	return a;
    }
}