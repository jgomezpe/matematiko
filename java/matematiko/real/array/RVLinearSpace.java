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

import matematiko.algebra.linear.LinearSpace;
import speco.real.RealUtil;

/**
 * <p>Linear space of real vectors.</p>
 *
 */
public class RVLinearSpace implements LinearSpace<double[]> {
	/**
	 * Gets the identity element 0. A real vector fill with 0 with the same dimension of the real vector <i>x</i>
	 * @param x Real vector for determining the dimension of the 0 real vector to return
	 * @return 0(x)
	 */
	@Override
	public double[] identity( double[] x ){ return RealUtil.create(x.length, 0.0); }

	/**
	 * Gets inverse real vector (fast version, may return the same object) of <i>x</i>.  
	 * @param x Real vector
	 * @return <i>-x</i>
	 */
	@Override
	public double[] fastInverse( double[] x ){
		for( int i=0; i<x.length; i++ ) x[i] = -x[i];
		return x;
	}

	/**
	 * Gets inverse real vector of <i>x</i>.  
	 * @param x Real vector
	 * @return <i>-x</i>
	 */
	@Override
	public double[] inverse( double[] x ){
		double[] y = new double[x.length];
		for( int i=0; i<x.length; i++ ) y[i] = -x[i];
		return y;
	}

	/**
	 * Adds x and y (returns the result in object <i>x</i>) 
	 * @param x First real vector
	 * @param y Second real vector
	 * @return <i>x + y</i>
	 */
	@Override
	public double[] fastPlus(double[] x, double[] y) {
		int n = x.length;
		for (int i = 0; i < n; i++)  x[i] += y[i];
		return x;
	}

	/**
	 * Adds x and -y (returns the result in object <i>x</i>) 
	 * @param x First real vector
	 * @param y Second real vector
	 * @return <i>x - y</i>
	 */
	@Override
	public double[] fastMinus(double[] x, double[] y) {
		int n = x.length;
		for (int i = 0; i < n; i++) x[i] -= y[i];
		return x;
	}

	/**
	 * Adds x and -y 
	 * @param x First real vector
	 * @param y Second real vector
	 * @return <i>x - y</i>
	 */
	@Override
	public double[] minus(double[] x, double[] y) {
		return fastMinus(x.clone(),y);
	}

	/**
	 * Adds x and y 
	 * @param x First real vector
	 * @param y Second real vector
	 * @return <i>x + y</i>
	 */
	@Override
	public double[] plus(double[] x, double[] y) {
		return fastPlus(x.clone(),y);
	}

	/**
	 * Divides real vector x by scalar k
	 * @param x Real vector
	 * @param k Scalar
	 * @return <i>(1/k)*x</i>
	 */
	@Override
	public double[] divide(double[] x, double k) {
		return fastDivide(x.clone(), k);
	}

	/**
	 * Divides real vector x by scalar k (return the result in object <i>x</i>)
	 * @param x Real vector
	 * @param k Scalar
	 * @return <i>(1/k)*x</i>
	 */
	@Override
	public double[] fastDivide(double[] x, double k) {
		int n = x.length;
		for (int i = 0; i < n; i++) x[i] /= k;
		return x;
	}

	/**
	 * Multiplies real vector x by scalar k (return the result in object <i>x</i>)
	 * @param x Real vector
	 * @param k Scalar
	 * @return <i>k*x</i>
	 */
	@Override
	public double[] fastMultiply(double[] x, double k) {
		int n = x.length;
		for (int i = 0; i < n; i++) x[i] *= k;
		return x;
	}

	/**
	 * Multiplies real vector x by scalar k
	 * @param x Real vector
	 * @param k Scalar
	 * @return <i>k*x</i>
	 */
	@Override
	public double[] multiply(double[] x, double k) {
		return fastMultiply(x.clone(), k);
	}    
}