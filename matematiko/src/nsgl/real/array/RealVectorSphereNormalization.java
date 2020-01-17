/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nsgl.real.array;

import nsgl.scale.Scale;

/**
 *
 * @author jgomez
 */
public class RealVectorSphereNormalization implements Scale<double[]>{
    protected RealVectorDotProduct dot = new RealVectorDotProduct();
    protected RealVectorSpace scale = new RealVectorSpace();
  /**
   * Applies the transformation on the data record
   * @param x Data record to be transformed
   */
  @Override  
  public double[] fastApply(double[] x) {
    double d = dot.norm(x);
    scale.fastDivide(x, d);
    return x;
  }  
}
