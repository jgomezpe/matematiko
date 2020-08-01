package nsgl.real;

/**
 *
 * @author jgomez
 */
public class LinearScale extends LinearScale01{
    protected LinearScale01 inverse;

    public LinearScale( double min, double max ){
        super( min, max );
        inverse = null;
    }


    public LinearScale( double originalMin, double originalMax,
                         double targetMin, double targetMax ){
        super( originalMin, originalMax );
        inverse = new LinearScale01(targetMin, targetMax);
    }

    @Override
    public double apply( double x ){
        if( inverse != null )
            return inverse.inverse(super.apply(x));
        else
            return super.apply(x);
    }

    @Override
    public double inverse( double x ){
        if( inverse != null )
            return super.inverse(inverse.apply(x));
        else
            return super.inverse(x);
    }
}