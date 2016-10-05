package com.dwardu.Matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by AbdulR3hman on 05/10/2016.
 */
public class MatrixTest {

    private Matrix m;

    @Before
    public void setUp()
    {
        //Setup 2X2 matrix
        double[][] t = new double[2][2];
        t[0][0] = 0;
        t[0][1] = 1;
        t[1][0] = 2;
        t[1][1] = 3;

        m = new Matrix(2,2);
        m.setValues(t);
    }

    @Test
    public void testMatrixRowSizeAndColumnSize()
    {
        assertEquals(2, m.getColumnSize());
        assertEquals(2, m.getRowSize());
    }

    @Test
    public void testMatrixElements()
    {
        assertEquals(0d, m.getValueAt(0,0),0.001);
        assertEquals(1d, m.getValueAt(0,1),0.001);
        assertEquals(2d, m.getValueAt(1,0),0.001);
        assertEquals(3d, m.getValueAt(1,1),0.001);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMatrixAfterShrinking()
    {
        m.arrangeMatrix(1,1);
        assertEquals(1, m.getColumnSize());
        assertEquals(1, m.getRowSize());
        assertEquals(0d, m.getValueAt(0,0),0.001);
        assertEquals(1d, m.getValueAt(0,1),0.001);
        //throws exception
        m.getValueAt(1,1);
    }

    @Test
    public void testMatrixAfterEnlarging()
    {
        m.arrangeMatrix(2,3);
        assertEquals(3, m.getColumnSize());
        assertEquals(2, m.getRowSize());
        assertEquals(0d, m.getValueAt(0,0),0.001);
        assertEquals(1d, m.getValueAt(0,1),0.001);
        assertEquals(0d, m.getValueAt(0,2),0.001);
    }


//    @Test
//    public void testAdd() {
//        String str = "Junit is working fine";
//        assertEquals("Junit is working fine",str);
//    }
//
//    @Test
//    public void testExceptionMessage() {
//        try {
//            new ArrayList<Object>().get(0);
//            fail("Expected an IndexOutOfBoundsException to be thrown");
//        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
//            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
//        }
//    }

}
