/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matematiko.scale;

import java.util.Iterator;

import kopii.Copier;
import speco.array.Array;

/**
 *
 * @author jgomez
 */
public interface Scale<T> {
    public T fastApply( T x );
    
    @SuppressWarnings("unchecked")
	default T apply( T x ){ return fastApply((T)Copier.apply(x)); }
    
    default Array<T> array( Array<T> a ){
        Array<T> v = a.instance(a.size());
        int i=0;
        Iterator<T> iter = a.iterator();
        while( iter.hasNext() ) v.set(i++,apply(iter.next()));
        return v;
    }
    
    default Array<T> fastArray( Array<T> a ){
    	try{ for( int i=0; i<a.size(); i++ ) a.set(i, fastApply(a.get(i))); }catch(Exception e){}
    	return a;
    }
}