package Tests;

import Classes.Matrix2x2;
import Classes.Vector2D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class Matrix2x2_Test {
    public final static double EPS = 1e-9;
    private static Matrix2x2 m, m1;

    @BeforeClass
    public static void createMatrix2x2() {
        m = new Matrix2x2(1, 2, 3, 4);
        m1 = new Matrix2x2(1, 2, 3, 4);
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(1, m.getA00(), EPS);
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(2, m.getA01(), EPS);
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(3, m.getA10(), EPS);
    }

    @Test
    public void constructorShouldSaveFourthParam() {
        Assert.assertEquals(4, m.getA11(), EPS);
    }

    @Test
    public void addMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(2, 4, 6, 8), m.add(m1));
    }

    @Test
    public void subMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(0), m.sub(m1));
    }

    @Test
    public void multNumberMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(2, 4, 6, 8), m.multNumber(2));
    }

    @Test
    public void multMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(7, 10, 15, 22), m.mult(m1));
    }

    @Test
    public void detMethodShouldBeRight() {
        Assert.assertEquals(-2, m.det(), EPS);
    }

    @Test
    public void inverseMatrixMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(1, 0, -3, 1), m.inverseMatrix());
    }

    @Test
    public void equivalentDiagonalMethodShouldBeRight() {
        Assert.assertEquals(new Matrix2x2(-3, 0, 0, 6), m.equivalentDiagonal());
    }

    @Test
    public void multVectorMethodShouldBeRight() {
        Vector2D v = mock(Vector2D.class);
        when(v.getX()).thenReturn(1.0);
        when(v.getX()).thenReturn(4.0);
        Assert.assertEquals(new Vector2D(12, 0), m.multVector(v));
    }
}
