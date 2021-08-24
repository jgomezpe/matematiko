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
package matematiko.real.array;
import java.util.Iterator;

import matematiko.real.LinearScale01;
import matematiko.scale.ReversableScale;


/**
 * <p>Title: RVLinearScale</p>
 *
 * <p>Description: A linear scaling process for real vectors</p>
 *
 */
public class RVLinearScale implements ReversableScale<double[]> {
	protected double originalMin;
	protected LinearScale01[] scale;

	/**
	 * Creates a <i>[0,1]^n</i> Real vector linear scale for a set of real vectors
	 *  (here <i>n</i> is the dimension of the real vectors).
	 * Computes the maximum and minimum values for each dimension of the real vector set.
	 * @param a Real vectors set to compute the scaling parameters
	 */
	public RVLinearScale( Iterable<double[]> a ){
		try{
			Iterator<double[]> iter = a.iterator();
			double[] min = iter.next().clone();
			double[] max = min.clone();
			double[] tmp;
			while( iter.hasNext()){
				tmp = iter.next();
				for( int j=0; j<min.length; j++ ){
					if( tmp[j] < min[j] ) min[j] = tmp[j];
    				else if( tmp[j] > max[j] ) max[j] = tmp[j];
				}
			}	
			scale = new LinearScale01[min.length];
			for( int i=0; i<scale.length; i++ )
				scale[i] = new LinearScale01(min[i], max[i]);
		}catch(Exception e){}      
	}
    
	/**
	 * Creates a real vector scaling process to the [min[i],max[i]] for all <i>i=0,..,n-1</i> hyper cube 
	 * @param min Minimum values of the hyper cube
	 * @param max Maximum values of the hyper cube
	 */
	public RVLinearScale( double[] min, double[] max ){
		scale = new LinearScale01[min.length];
		for( int i=0; i<scale.length; i++ )
			scale[i] = new LinearScale01(min[i], max[i]);
	}

	/**
	 * Creates a real vector scaling process to the [targetMin[i],targetMax[i]] from the
	 * [originalMin[i],originalMax[i]] for all <i>i=0,..,n-1</i> hyper cubes
	 * @param targetMin Minimum values of the target hyper cube
	 * @param targetMax Maximum values of the target hyper cube
	 * @param originalMin Minimum values of the original hyper cube
	 * @param originalMax Maximum values of the original hyper cube
	 */
	public RVLinearScale( double[] originalMin, double[] originalMax,
						double[] targetMin, double[] targetMax ){
		scale = new LinearScale01[originalMin.length];
		for( int i=0; i<scale.length; i++ )
			scale[i] = new matematiko.real.LinearScale(originalMin[i], originalMax[i], targetMin[i], targetMax[i]);        
	}

	/**
	 * Scales a real vector (returns the result in the same real vector)
	 * @param x Real vector to scale
	 * @return Scaled real vector
	 */
	@Override
	public double[] fastApply( double[] x ){
		for( int i=0; i<x.length; i++ ) x[i] = scale[i].apply(x[i]);
		return x;
	}

	/**
	 * Unscales a real vector (returns the result in the same real vector)
	 * @param x Real vector to unscale
	 * @return Unscaled real vector
	 */
	@Override
	public double[] fastReverse( double[] x ){
		for( int i=0; i<x.length; i++ ) x[i] = scale[i].reverse(x[i]);
		return x;
	}
}