/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matematiko.scale;

import speco.array.Array;
import kopii.Copier;
/**
 *
 * @author jgomez
 */
public interface Invertable<T> extends Scale<T>{
    public T fastInverse( T x );
    
    @SuppressWarnings("unchecked")
    default T inverse( T x ){ return fastInverse((T)Copier.apply(x)); }
    
    @SuppressWarnings("unchecked")
    default Array<T> inverseArray( Array<T> a ){
	a = (Array<T>)a.copy();
        for( int i=0; i<a.size(); i++ ) a.set(i, inverse(a.get(i)));
        return a;
    } 
    
    default Array<T> fastInverseArray( Array<T> a ){
        for( int i=0; i<a.size(); i++ ) a.set(i, fastInverse(a.get(i)));
        return a;
    }    
}