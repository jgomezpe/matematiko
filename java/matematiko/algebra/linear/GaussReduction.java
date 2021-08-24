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
package matematiko.algebra.linear;

import kompari.real.PrecisionOrder;
import matematiko.real.matrix.RealMatrix;

/**
 * <p>Title: GaussReduction</p>
 *
 * <p>Description: Solves (if possible) a linear system, using the Gauss Jordan reduction Method</p>
 *
 */
public class GaussReduction implements LinearSystemSolver{
	/**
	 * Solves a linear system
	 * @param A Coefficients matrix
	 * @param b Independents array term
	 * @return Solution values, if possible, for the linear system
	 */
	public double[] solve( double[][] A, double[] b ){
		int n = RealMatrix.rows(A);
		int m = RealMatrix.columns(A);
		b = (double[]) b.clone();
		double[] x = null;
		if (b.length == n) {
			A = A.clone();
			int[] perm = new int[m];
			for (int i = 0; i < m; i++) perm[i] = i;

			for (int i = 0; i < n; i++) {
				int k = i;
				while (k < m && PrecisionOrder.isZero(A[i][k])) k++;
				if (k < m) {
					if (k != i) {
						int ti = perm[i];
						perm[i] = perm[k];
						perm[k] = ti;
						double t;
						for (int j = 0; j < n; j++) {
							t = A[i][j];
							A[i][j] = A[k][j];
							A[k][j] = t;
						}
					}
					double pivot = A[i][i];
					for (int j = 0; j < m; j++)  A[i][j] /= pivot;
					b[i] /= pivot;
					for (k = 0; k < n; k++) {
						if (k != i) {
							pivot = A[k][i];
							for (int j = 0; j < m; j++) {
								A[k][j] -= pivot * A[i][j];
							}
							b[k] -= pivot * b[i];
						}
					}
				} else {
					if(!PrecisionOrder.isZero(b[i])) {
						return null;
					}else{
						b[i] = Double.POSITIVE_INFINITY;
					}
				}
			}
			x = new double[m];
			for( int i=0; i<m; i++ ) x[i] = Double.POSITIVE_INFINITY;
			for( int i=0; i<Math.min(n,m); i++ ) x[perm[i]] = b[i];
		}
		return x;
	}
}