/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matematiko.scale;

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
    
    @SuppressWarnings("unchecked")
    default Array<T> array( Array<T> a ){
        a = (Array<T>)a.copy();
        for( int i=0; i<a.size(); i++ ) a.set(i, apply(a.get(i)));
        return a;
    }
    
    default Array<T> fastArray( Array<T> a ){
    	for( int i=0; i<a.size(); i++ ) a.set(i, fastApply(a.get(i)));
    	return a;
    }
}