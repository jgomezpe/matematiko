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
package matematiko.statistics;

import java.util.TreeMap;

/**
 * <p>Title: Histogram</p>
 *
 * <p>Description: A histogram of values</p>
 *
 */
public class Histogram<K> {
	protected TreeMap<K, Integer> map = new TreeMap<K, Integer>();
		
	/**
	 * Creates an empty histogram
	 */
	public Histogram(){}
	
	/**
	 * Adds an amount to a value's frequency.
	 * If the value is not in the histogram, its initial frequency will be set to the amount value
	 * @param value Value
	 * @param amount Amount to increase/decrease a value's frequency
	 */
	public void add( K value, int amount ){
		Integer current = map.get(value);
		current = current!=null?current+amount:amount;
		map.put(value, current);
	}
	
	/**
	 * Increases the frequency of the value in a unit
	 * @param value Value to increase its frequency
	 */
	public void inc( K value ){ add( value, 1 ); }
	
	/**
	 * Decreases the frequency of the value in a unit
	 * @param value Value to decrease its frequency
	 */
	public void dec( K value ){ add( value, -1 ); }
	
	/**
	 * Computes the histogram frequency mode
	 * @return Histogram frequency mode
	 */
	public K mode(){
		K m = null;
		int min=Integer.MIN_VALUE;
		int v;
		for(K value:map.keySet()) {
			v = map.get(value);
			if(v>min) {
				min = v;
				m = value;
			}	 
		}
		return m;
	}
	
	/**
	 * Removes all values in the histogram
	 */
	public void clear(){ map.clear(); }
	
	/**
	 * Gets the set of values in the histogram (no their frequencies)
	 * @return Set of values in the histogram
	 */
	public Iterable<K> values(){ return map.keySet(); }	
}