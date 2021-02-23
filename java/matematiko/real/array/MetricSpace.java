/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matematiko.real.array;

import matematiko.metric.MetricLinearSpace;
import matematiko.metric.QuasiMetric;

/**
 *
 * @author jgomez
 */
public class MetricSpace extends LinearSpace 
        implements MetricLinearSpace<double[]> {
    protected QuasiMetric<double[]> metric;
    public MetricSpace( QuasiMetric<double[]> metric ){
        this.metric = metric;
    }
    @Override
    public double apply(double[] x, double[] y) {
        return metric.apply(x, y);
    }    
}
