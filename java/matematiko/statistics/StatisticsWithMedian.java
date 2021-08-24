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

import kompari.real.RealL2HOrder;
import speco.array.sort.Merge;

/**
 * <p>Statistical information of numeric variables, includes median</p>
 *
 */
public class StatisticsWithMedian extends Statistics{
	protected double median;
  
	/**
	 * Creates an empty statistical information
	 */
	public StatisticsWithMedian() {}

	/**
	 * Computes the statistical information of the given array of doubles
	 * @param x Array to be statistically analyzed
	 */
	public StatisticsWithMedian(double[] x) {
		super( x );
		compute_median(x.clone());
	}

	/**
	 * Computes the statistical information of the given column of a double matrix
	 * @param x Matrix to be statistically analyzed
	 * @param c column to be analyzed
	 */
	public StatisticsWithMedian(double[][] x, int c) {
		super( x, c );
		double[] y = new double[x.length];
		for( int i=0; i<y.length; i++ ) y[i] = x[i][c];
		compute_median(y);
	}

	/**
	 * Computes the statistical information of the given row of a double matrix
	 * @param r Row to be analyzed
	 * @param x Matrix to be statistically analyzed
	 */
	public StatisticsWithMedian(int r, double[][] x ) {
		super( r, x );
		compute_median( x[r].clone() );
	}
    
	/**
	 * Computes the median value of an array
	 * @param x Array to be analyzed
	 */
	private void compute_median(double[] x){
		Merge<Double> merge = new Merge<Double>(new RealL2HOrder());
		x = x.clone();
		merge.apply(x);
		int n = x.length;
		median = ((n%2)==0)?(x[n/2]+x[n/2-1])/2.0:x[n/2];
	}

	/**
	 * Obtains the statistical information in an array of doubles format (min, max, average, variance, deviation)
	 * @return Statistical information in an array of doubles format
	 */
	@Override
	public double[] get() {
		double[] values = new double[6];
		values[0] = min;
		values[1] = max;
		values[2] = median;
		values[3] = avg;
		values[4] = variance;
		values[5] = deviation;
		return values;
	}  
    
	/**
	 * Obtains the statistical information of the array (min, max, median, average, variance, deviation)
	 * @param x Array to analyze
	 * @return Statistical information in an array of doubles format
	 */
	public static double[] get( double[] x ) { return (new StatisticsWithMedian(x)).get(); }    
}