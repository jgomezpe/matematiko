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
package matematiko.metric;

import kompari.Order;
import kompari.real.RealOrder;
import kompari.real.L2HOrder;

/**
 * <p>Title: DistanceOrder</p>
 * <p>Description: Defines an order based on the distance to a predefined element </p>
 * @param <T>: Type of elements the order is computed on
 *
 */
public class DistanceOrder<T> implements Order<T>{
	protected Distance<T> distance;
	protected T point;
	protected RealOrder order;
	
	/**
	 * Creates an order based on the distance to a predefined element
	 * @param distance Distance measure
	 * @param point Predefined element used for computing distance of the element
	 */
	public DistanceOrder( Distance<T> distance, T point ){
		this.distance = distance;
		this.point = point;
		this.order = new L2HOrder();
	}

	/**
	 * Determines if one elements is less, equal or greater than other (depending on distance to the predefined element).
	 * @param x First object to be compared
	 * @param y Second object to be compared
	 * @return A value less than 0 indicates that <i>x</i> is less than <i>y</i>, a value equal to 0 indicates
	 * that <i>x</i> is equal to <i>y</i> and a value greater than 0 indicates that <i>x</i> is greater than <i>y</i>
	 */
	@Override
	public int compare(T x, T y){ return order.compare(distance.apply(x,point),distance.apply(y,point)); }
}