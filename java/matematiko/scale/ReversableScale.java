/**
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2019 by Jonatan Gomez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * @author <A HREF="http://disi.unal.edu.co/profesores/jgomezpe"> Jonatan Gomez-Perdomo </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 */
package matematiko.scale;

import speco.array.Array;
import kopii.Copier;

/**
 * <p>Scale process that can be reversed</p>
 *
 */
public interface ReversableScale<T> extends Scale<T>{
	/**
	 * Reverses the scaling process (may return the result in the same object) 
	 * @param x Object to be unscaled
	 * @return Unscaled version of <i>x</i>
	 */
	public T fastReverse( T x );
    
	/**
	 * Reverses the scaling process 
	 * @param x Object to be unscaled
	 * @return Unscaled version of <i>x</i>
	 */
	@SuppressWarnings("unchecked")
	default T reverse( T x ){ return fastReverse((T)Copier.apply(x)); }
    
	/**
	 * Unscales an array of objects
	 * @param a Objects to scale
	 * @return Unscaled objects
	 */
	@SuppressWarnings("unchecked")
	default Array<T> reverseArray( Array<T> a ){
		a = (Array<T>)a.copy();
		for( int i=0; i<a.size(); i++ ) a.set(i, reverse(a.get(i)));
		return a;
	} 
    
	/**
	 * Unscales an array of objects (return the same array)
	 * @param a Objects to scale
	 * @return Unscaled objects
	 */
	default Array<T> fastReverseArray( Array<T> a ){
		for( int i=0; i<a.size(); i++ ) a.set(i, fastReverse(a.get(i)));
		return a;
	}    
}