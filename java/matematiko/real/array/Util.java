package matematiko.real.array;

import kompari.real.PrecisionOrder;

public class Util {

    /**
     * Reverses the given array
     * @param a Double array to be reversed
     */
    public static void invert(double[] a) {
        int n = a.length;
        int j = n - 1;
        for (int i = 0; i < j; i++) {
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            j--;
        }
    }

    /**
     * Normalizes the array to the interval [0,1] using the sum of the values in the array as the maximum value
     * (precondition: Values in the array should be non negatives and at least one value should be different of zero
     * @param x Array to be normalized
     */
    public static void normalize( double[] x ){
    int n = x.length;
        double sum = 0.0;
        for( int i=0; i<n; i++ ){
            sum +=  x[i];
        }
        if( !PrecisionOrder.isZero(sum) ){
            for (int i = 0; i < n; i++) {
                x[i] /= sum;
            }
        }
    }
    
    public static double max(double[] a){
        double m = a[0];
        for( int i=1; i<a.length; i++ ){
            if( m < a[i] ){
                m = a[i];
            }
        }
        return m;
    }
    
    public static double min(double[] a){
        double m = a[0];
        for( int i=1; i<a.length; i++ ){
            if( m > a[i] ){
                m = a[i];
            }
        }
        return m;
    }   

    public static double[] create(int n, double v) {
	double[] x = new double[n];
	for( int i=0; i<n; i++ ) x[i] = v;
	return x;
    }
}
