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
package matematiko.real;

/**
 * <p>Title: LinearScale</p>
 *
 * <p>Description: A linear scaling process to the [min,max] interval for the [originalmin,originalmax] interval</p>
 *
 */
public class LinearScale extends LinearScale01{
	protected LinearScale01 inverse;

	/**
	 * Creates a [0,1] linear scale considering the given maximum and minimum values 
	 * @param min Minimum value goes to 0
	 * @param max Maximum value goes to 1
	 */
	public LinearScale( double min, double max ){
		super( min, max );
		inverse = null;
	}

	/**
	 * Creates a [min,max] linear scale for the [originalmin,originalmax] interval 
	 * @param originalMin Value that goes to the new <i>min</i> value
	 * @param originalMax Value that goes to the new <i>max</i> value
	 * @param targetMin New minimum value
	 * @param targetMax New maximum value
	 */
	public LinearScale( double originalMin, double originalMax, double targetMin, double targetMax ){
		super( originalMin, originalMax );
		inverse = new LinearScale01(targetMin, targetMax);
	}

	/**
	 * Scales a real
	 * @param x Real to scale
	 * @return Scaled real
	 */
	@Override
	public double apply( double x ){
		if( inverse != null ) return inverse.reverse(super.apply(x));
		else return super.apply(x);
	}

	/**
	 * Reverses the scaling process 
	 * @param x Real to be unscaled
	 * @return Unscaled version of <i>x</i>
	 */
	@Override
	public double reverse( double x ){
		if( inverse != null ) return super.reverse(inverse.apply(x));
		else return super.reverse(x);
	}
}