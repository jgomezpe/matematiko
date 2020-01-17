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
public interface Invertable<T> extends Scale<T>{
    public T fastInverse( T x );
    
    @SuppressWarnings("unchecked")
	default T inverse( T x ){ return fastInverse((T)Copyable.cast(x).copy()); }
    
    default ArrayInterface<T> inverseArray( ArrayInterface<T> a ){
        ArrayInterface<T> v = a.instance(a.size());
        int i=0;
        Iterator<T> iter = a.iterator();
        while( iter.hasNext() ) v.set(i++, inverse(iter.next()));
        return v;
    } 
    
    default ArrayInterface<T> fastInverseArray( ArrayInterface<T> a ){
        try{ for( int i=0; i<a.size(); i++ ) a.set(i, fastInverse(a.get(i))); }catch(Exception e){}
        return a;
    }    
}