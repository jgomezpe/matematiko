package matematiko.real;

/**
 * <p>Set of constants and methods operating on the primitive double data type,
 * for example, for defining the precision in math operations</p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */
public class Util {
    public static double cast( Object x ){
	if( x instanceof Double ) return (Double)x;
	else return (Integer)x;
    } 	
}