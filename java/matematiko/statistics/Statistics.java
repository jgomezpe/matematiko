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

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 */
/**
 * <p>Statistical information of numeric variables</p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */
public class Statistics {
	/**
	 * Index of the min value of the set
	 */
	public int minIndex = 0;
  
	/**
	 * Index of the max value of the set
	 */
	public int maxIndex = 0;
    
	/**
	 * Min value of the set
	 */
	public double min = 0.0;
    
	/**
	 * Max value of the set
	 */
	public double max = 0.0;
    
	/**
	 * Average value of the set
	 */
	public double avg = 0.0;
    
	/**
	 * Variance of the set
	 */
	public double variance = 0.0;
    
	/**
	 * Deviation of the set
	 */
	public double deviation = 0.0;

	/**
	 * Creates an empty statistical information
	 */
	public Statistics() {}

	/**
	 * Computes the statistical information of the given array of doubles
	 * @param x Array to be statistically analized
	 */
	public Statistics(double[] x) {
		int n = x.length;
		min = max = avg = x[0];
		for (int i = 1; i < n; i++) {
			if (x[i] < min) {
				min = x[i];
				minIndex = i;
			} else {
				if (x[i] > max) {
					max = x[i];
					maxIndex = i;
				}
			}
			avg += x[i];
		}
		avg /= n;
		for (int i = 0; i < n; i++) variance += (x[i] - avg) * (x[i] - avg);
		variance /= (n>1)?(n - 1):1.0;
		deviation = Math.sqrt(variance);
	}

	/**
	 * Computes the statistical information of the given column of a double matrix
	 * @param x Matrix to be statistically analized
	 * @param c column to be analized
	 */
	public Statistics(double[][] x, int c) {
		int n = x.length;
		min = max = avg = x[0][c];
		for (int i = 1; i < n; i++) {
			if (x[i][c] < min) {
				min = x[i][c];
				minIndex = i;
			} else {
				if (x[i][c] > max) {
					max = x[i][c];
					maxIndex = i;
				}
			}
			avg += x[i][c];
		}
		avg /= n;
		for (int i = 0; i < n; i++) variance += (x[i][c] - avg) * (x[i][c] - avg);
		variance /= (n>1)?(n - 1):1.0;
		deviation = Math.sqrt(variance);
	}

	/**
	 * Computes the statistical information of the given row of a double matrix
	 * @param r Row to be analized
	 * @param x Matrix to be statistically analized
	 */
	public Statistics(int r, double[][] x ) { this( x[r] ); }

	/**
	 * Obtains the statistical information in an array of doubles format (min, max, average, variance, deviation)
	 * @return Statistical information in an array of doubles format
	 */
	public double[] get() {
		double[] values = new double[5];
		values[0] = min;
		values[1] = max;
		values[2] = avg;
		values[3] = variance;
		values[4] = deviation;
		return values;
	}
    
	/**
	 * Obtains the statistical information of the array (min, max, average, variance, deviation)
	 * @param x Array to analyze
	 * @return Statistical information in an array of doubles format
	 */
	public static double[] get( double[] x ) { return (new Statistics(x)).get(); }
}