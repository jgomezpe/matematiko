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
package matematiko.real.metrics;

import matematiko.metric.*;

/**
 * <p>Title: PMinkowski</p>
 * <p>Description: Calculates the PMinkowski distance between two real vectors,
 * <p>without calculating the p-root</p>
 */
public class PMinkowski implements Distance<double[]> {
	/**
	 * The PMinkowski coefficient
	 */
	protected double p;

	/**
	 * Creates a PMinkowski distance object with the given PMinkowski coefficient, without calculating the p-root
	 * @param p PMinkowski coefficient
	 */
	public PMinkowski(double p) { this.p = p; }

	/**
	 * Calculates the PMinkowski distance from one real vector to another.
	 * This object does not calculate the p-root
	 * @param x The first real vector
	 * @param y The second real vector
	 * @return PMinkowski distance (without calculating the p-root from object x to object y
	 */
	public double apply(double[] x, double[] y) {
		double s = 0.0;
		int n = x.length;
		for (int i = 0; i < n; i++)  s += Math.pow(Math.abs(x[i] - y[i]), p);
		return s;
	}
  

	/**
	 * Returns the PMinkowski coefficient
	 * @return The PMinkowski coefficient
	 */
	public double coeficient() { return p; } 
}