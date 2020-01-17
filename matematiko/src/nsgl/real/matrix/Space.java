package nsgl.real.matrix;
import nsgl.algebra.linear.LinearSpace;
import nsgl.copy.Copyable;
import nsgl.real.matrix.Matrix;

/**
 * <p>Title: DoubleMatrixVectorSpace</p>
 * <p>Description: Adds and Subtracts matrices.</p>
 * <p>Copyright:    Copyright (c) 2006</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Jonatan Gomez Reviewed by (Aurelio Benitez, Giovanni Cantor, Nestor Bohorquez)
 * @version 1.0
 */

public class Space implements LinearSpace<double[][]> {
    @Override
    public double[][] identity( double[][] x ){
        int n = Matrix.rows(x);
        int m = Matrix.columns(x);
        return Matrix.zero(n,m);
    }

    @Override
    public double[][] fastInverse( double[][] x ){
        int n = Matrix.rows(x);
        int m = Matrix.columns(x);
        for( int i=0; i<n; i++ ){
            for( int j=0; j<m; j++ ){
                x[i][j] = -x[i][j];
            }
        }
        return x;
    }

    @Override
    public double[][] inverse( double[][] x ){
        int n = Matrix.rows(x);
        int m = Matrix.columns(x);
        double[][] y = new double[n][m];
        for( int i=0; i<n; i++ ){
            for( int j=0; j<m; j++ ){
                y[i][j] = -x[i][j];
            }
        }
        return y;
    }

    /**
     * Adds to the second matrix the first matrix. The addition process is component by component
     * x[i,j] = x[i,j] + y[i,j] for all i=1..n and j=1..m
     * The result of the operation is stored in the first matri
     * @param x The first matrix
     * @param y The matrix to be added
     */
    @Override
    public double[][] fastPlus(double[][] x, double[][] y) {
        int n = Matrix.rows(x);
        int m = Matrix.columns(x);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] += y[i][j];
            }
        }
        return x;
    }

    /**
     * Substracts a matrix from the first matri
     * The substraction process is component by component. The substraction process is component by component
     * x[i,j] = x[i,j] - y[i,j] for all i=1..n and j=1..m
     * The result of the operation is stored in the first matri
     * @param x The first matrix
     * @param y The matrix to be substracted
     */
    @Override
    public double[][] fastMinus(double[][] x, double[][] y) {
        int n = Matrix.rows(x);
        int m = Matrix.columns(x);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] -= y[i][j];
            }
        }
        return x;
    }
  
    /**
     * Multiplies a matrix by an scalar.
     * @param y The matrix
     * @param x The Scalar
     */
    @Override
    public double[][] fastMultiply(double[][] y, double x) {
        int n = Matrix.rows(y);
        int m = Matrix.columns(y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                y[i][j] *= x;
            }
        }
        return y;
    }

    /**
     * Divides a matrix by an scalar.
     * @param y The matrix
     * @param x The Scalar
     */
    @Override
    public double[][] fastDivide(double[][] y, double x) {
        int n = Matrix.rows(y);
        int m = Matrix.columns(y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                y[i][j] /= x;
            }
        }
        return y;
    }
    
    protected double[][] create(double[][] x){ return (double[][])Copyable.cast(x).copy(); }
    
    @Override
    public double[][] minus(double[][] one, double[][] two) {
        return fastMinus(create(one), two);
    }

    @Override
    public double[][] plus(double[][] one, double[][] two) {
        return fastPlus(create(one), two);
    }

    @Override
    public double[][] divide(double[][] one, double x) {
        return fastDivide(create(one), x);
    }

    @Override
    public double[][] multiply(double[][] one, double x) {
        return fastMultiply(create(one), x);
    }
}