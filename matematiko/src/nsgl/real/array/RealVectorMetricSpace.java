/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nsgl.real.array;

import nsgl.metric.MetricLinearSpace;
import nsgl.metric.QuasiMetric;

/**
 *
 * @author jgomez
 */
public class RealVectorMetricSpace extends RealVectorSpace 
        implements MetricLinearSpace<double[]> {
    protected QuasiMetric<double[]> metric;
    public RealVectorMetricSpace( QuasiMetric<double[]> metric ){
        this.metric = metric;
    }
    @Override
    public double apply(double[] x, double[] y) {
        return metric.apply(x, y);
    }    
}
