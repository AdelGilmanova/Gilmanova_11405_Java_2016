package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.ComplexMatrix2x2;
import ru.kpfu.itis.java.Gilmanova.classes.ComplexNumber;
import ru.kpfu.itis.java.Gilmanova.classes.ComplexVector2D;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 23.02.2016.
 */
public class ComplexMatrix2x2_Test {
    private static ComplexMatrix2x2 cm, cm1;
    private static ComplexNumber cn;
    private static ApplicationContext ac;

    @BeforeClass
    public static void createComplexMatrix2x2() {
        ac = new ClassPathXmlApplicationContext("spring-config.xml");

        cn = mock(ComplexNumber.class);
        when(cn.getRe()).thenReturn(0.0);
        when(cn.getIm()).thenReturn(0.0);
        when(cn.mult((ComplexNumber) anyObject())).thenReturn(new ComplexNumber(0, 0));
        when(cn.sub((ComplexNumber) anyObject())).thenReturn(new ComplexNumber(0, 0));

//        cm = new ComplexMatrix2x2(cn);
//        cm1 = new ComplexMatrix2x2(cn);
        cm = (ComplexMatrix2x2) ac.getBean("cm");
        cm.setA00(cn);
        cm.setA01(cn);
        cm.setA10(cn);
        cm.setA11(cn);

        cm1 = (ComplexMatrix2x2) ac.getBean("cm");
        cm1.setA00(cn);
        cm1.setA01(cn);
        cm1.setA10(cn);
        cm1.setA11(cn);
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
        ComplexMatrix2x2 cm3 = (ComplexMatrix2x2) ac.getBean("cm");
        cm3.setA00(cn);
        cm3.setA01(cn);
        cm3.setA10(cn);
        cm3.setA11(cn);

        Assert.assertEquals(cm.add(cm1), cm3);
    }

    @Test
    public void multMethodShouldBeRight() {
        ComplexMatrix2x2 cm3 = (ComplexMatrix2x2) ac.getBean("cm");
        cm3.setA00(cn);
        cm3.setA01(cn);
        cm3.setA10(cn);
        cm3.setA11(cn);

        Assert.assertEquals(cm.mult(cm1), cm3);
    }

    @Test
    public void detMethodShouldBeRight() {
        ComplexNumber cn = (ComplexNumber) ac.getBean("cn");

        Assert.assertEquals(cm.det(), cn);
    }

    @Test
    public void multVectorMethodShouldBeRight() {
        ComplexVector2D cv = mock(ComplexVector2D.class);
        when(cv.getC()).thenReturn(cn);
        when(cv.getC1()).thenReturn(cn);

        ComplexVector2D cv2 = (ComplexVector2D) ac.getBean("cv");
        cv2.setC(cn);
        cv.setC1(cn);

        Assert.assertEquals(cm.multVector(cv), cv2);
    }

}
