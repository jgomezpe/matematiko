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
package matematiko.real.matrix;
import kopii.Copier;
import matematiko.algebra.*;

/**
 * <p>Real matrix direct product.</p>
 *
 */
public class RMDirectProduct implements Group<double[][]> {
	/**
	 * Gets the 1s matrix. A real matrix fill with 1 with the same dimension of the real matrix <i>x</i>
	 * @param x Real matrix for determining the dimension of the 1 real matrix to return
	 * @return 1(x)
	 */
	public double[][] identity( double[][] x ){
		int n = RealMatrix.rows(x);
		int m = RealMatrix.columns(x);
		double[][] y = new double[n][m];
		for( int i=0; i<n; i++ )
			for( int j=0; j<n; j++ ) y[i][j] = 1.0;
		return y;
	}

	/**
	 * Gets inverse real matrix (fast version, may return the same object) of <i>x</i>, i.e., <i>x[i][j] = 1/x[i][j]</i>
	 * @param x Real matrix
	 * @return <i>-x</i>
	 */
	public double[][] fastInverse( double[][] x ){
		int n = RealMatrix.rows(x);
		for( int i=0; i<n; i++ )
			for( int j=0; j<n; j++ ) x[i][j] = 1.0/x[i][j];
		return x;
	}

	/**
	 * Gets inverse real matrix, i.e., <i>y[i][j] = 1/x[i][j]</i>
	 * @param x Real matrix
	 * @return <i>-x</i>
	 */
	public double[][] inverse( double[][] x ){
		int n = RealMatrix.rows(x);
		int m = RealMatrix.columns(x);
		double[][] y = new double[n][m];
		for( int i=0; i<n; i++ )
            for( int j=0; j<n; j++ ) y[i][j] = 1.0/x[i][j];
		return y;
	}

	/**
	 * Multiplies x and y (returns the result in object <i>x</i>) 
	 * @param x First real matrix
	 * @param y Second real matrix
	 * @return <i>x[i][j] = x[i][j] * y[i][j]</i>
	 */
	public double[][] fastPlus(double[][] x, double[][] y) {
		int n = RealMatrix.rows(y);
		int m = RealMatrix.columns(y);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) x[i][j] *= y[i][j];
		return x;
	}

	/**
	 * Divides x and y (returns the result in object <i>x</i>) 
	 * @param x First real matrix
	 * @param y Second real matrix
	 * @return <i>x[i][j] = x[i][j] / y[i][j]</i>
	 */
	public double[][] fastMinus(double[][] x, double[][] y) {
		int n = RealMatrix.rows(y);
		int m = RealMatrix.columns(y);
		for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) x[i][j] /= y[i][j];
		return x;
	}
    
	/**
	 * Creates a clx of the given real matrix
	 * @param x Real matrix
	 * @return Clx of the real matrix
	 */
	protected double[][] create(double[][] x){ return (double[][])Copier.apply(x); }
    
	/**
	 * Divides x and y 
	 * @param x First real matrix
	 * @param y Second real matrix
	 * @return <i>z[i][j] = x[i][j] / y[i][j]</i>
	 */
	@Override
	public double[][] minus(double[][] x, double[][] y) {
		return fastMinus(create(x), y);
	}

	/**
	 * Multiplies x and y  
	 * @param x First real matrix
	 * @param y Second real matrix
	 * @return <i>z[i][j] = x[i][j] * y[i][j]</i>
	 */
	@Override
	public double[][] plus(double[][] x, double[][] y) {
		return fastPlus(create(x), y);
	}   
}