package matematiko.algebra.linear;

import kopii.Copier;

/**
 * <p>Title: ScalarProduct</p>
 * <p>Description: Abstract class, multiplies and divide one
 *  object for one scalar.</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Jonatan Gomez
 * @version 1.0
 *
 */
public interface ScalarProduct<T> {
    /**
     * Multiplies object one and the scalar x
     * @param one The object
     * @param x The scalar
     * @return The resulting object of multiplying the given object by scalar x
     */
    T fastMultiply(T one, double x);

    /**
     * Divides object one by the scalar x
     * @param one The object
     * @param x The scalar
     * @return The resulting object of dividing the given object by scalar x
     */
    default T fastDivide(T one, double x) { return fastMultiply(one, 1.0/x); }

    /**
     * Multiplies object one copy and the scalar x
     * @param one The object
     * @param x The scalar
     * @return The resulting object of multiplying the given object by scalar x
     */
    @SuppressWarnings("unchecked")
	default T multiply(T one, double x){ return fastMultiply((T)Copier.apply(one), x); }

    /**
     * Divide object one copy by the scalar x
     * @param one The object
     * @param x The scalar
     * @return The resulting object of dividing the given object by scalar x
     */
    @SuppressWarnings("unchecked")
	default T divide(T one, double x){ return fastDivide((T)Copier.apply(one), x); }    
}
