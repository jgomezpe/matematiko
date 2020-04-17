package nsgl.real.array;
import java.util.Iterator;

import nsgl.scale.Invertable;
import nsgl.real.LinearScale01;


public class LinearScale implements Invertable<double[]> {
    protected double originalMin;
    protected LinearScale01[] scale;

    public LinearScale( Iterable<double[]> a ){
    	try{
    		Iterator<double[]> iter = a.iterator();
    		double[] min = iter.next().clone();
    		double[] max = min.clone();
    		double[] tmp;
    		while( iter.hasNext()){
    			tmp = iter.next();
    			for( int j=0; j<min.length; j++ ){
    				if( tmp[j] < min[j] ){
    					min[j] = tmp[j];
    				}else{
    					if( tmp[j] > max[j] ){
    						max[j] = tmp[j];
    					}
    				}
    			}
    		}	
            scale = new LinearScale01[min.length];
            for( int i=0; i<scale.length; i++ ){
                scale[i] = new LinearScale01(min[i], max[i]);
            }
      }catch(Exception e){}      
    }
    
    public LinearScale( double[] min, double[] max ){
        scale = new LinearScale01[min.length];
        for( int i=0; i<scale.length; i++ ){
            scale[i] = new LinearScale01(min[i], max[i]);
        }
    }


    public LinearScale( double[] originalMin, double[] originalMax,
                             double[] targetMin, double[] targetMax ){
        scale = new LinearScale01[originalMin.length];
        for( int i=0; i<scale.length; i++ ){
            scale[i] = new nsgl.real.LinearScale(originalMin[i], originalMax[i], targetMin[i], targetMax[i]);
        }
    }

    @Override
    public double[] fastApply( double[] x ){
        for( int i=0; i<x.length; i++ ){
            x[i] = scale[i].apply(x[i]);
        }
        return x;
    }

    @Override
    public double[] fastInverse( double[] x ){
        for( int i=0; i<x.length; i++ ){
            x[i] = scale[i].inverse(x[i]);
        }
        return x;
    }
}