package Tests;

import Classes.ComplexMatrix2x2;
import Classes.ComplexNumber;
import Classes.ComplexVector2D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class ComplexMatrix2x2_Test {
    private static ComplexMatrix2x2 cm, cm1;
    private static ComplexNumber cn;

    @BeforeClass
    public static void createComplexMatrix2x2() {
        cn = mock(ComplexNumber.class);
        when(cn.getRe()).thenReturn(0.0);
        when(cn.getIm()).thenReturn(0.0);
        when(cn.mult((ComplexNumber) anyObject())).thenReturn(new ComplexNumber(0, 0));
        when(cn.sub((ComplexNumber) anyObject())).thenReturn(new ComplexNumber(0, 0));

        cm = new ComplexMatrix2x2(cn);
        cm1 = new ComplexMatrix2x2(cn);
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(cm.getA00(), cn);
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(cm.getA01(), cn);
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(cm.getA10(), cn);
    }

    @Test
    public void constructorShouldSaveFourthParam() {
        Assert.assertEquals(cm.getA11(), cn);
    }

    @Test
    public void addMethodShouldBeRight() {
        Assert.assertEquals(cm.add(cm1), new ComplexMatrix2x2(cn));
    }

    @Test
    public void multMethodShouldBeRight() {
        Assert.assertEquals(cm.mult(cm1), new ComplexMatrix2x2(cn));
    }

    @Test
    public void detMethodShouldBeRight() {
        Assert.assertEquals(cm.det(), new ComplexNumber(0, 0));
    }

    @Test
    public void multVectorMethodShouldBeRight() {
        ComplexVector2D cv = mock(ComplexVector2D.class);
        when(cv.getC()).thenReturn(cn);
        when(cv.getC1()).thenReturn(cn);

        Assert.assertEquals(cm.multVector(cv), new ComplexVector2D(cn, cn));
    }

}
