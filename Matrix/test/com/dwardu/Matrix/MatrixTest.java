package com.dwardu.Matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by AbdulR3hman on 05/10/2016.
 */
public class MatrixTest {

    private Matrix matrixA;
    private Matrix matrixATwin;
    private Matrix matrixB;

    @Before
    public void setUp()
    {
        //Setup 2X2 matrix
        double[][] t = new double[2][2];
        double[][] v = new double[2][2];
        t[0][0] = 0;
        t[0][1] = 1;
        t[1][0] = 2;
        t[1][1] = 3;

        v[0][0] = 1;
        v[0][1] = 1;
        v[1][0] = 1;
        v[1][1] = 1;

        matrixA = new Matrix(2,2);
        matrixB = new Matrix(2,2);
        matrixATwin = new Matrix(2,2);
        matrixA.setValues(t);
        matrixB.setValues(v);
        matrixATwin.setValues(t);
    }

    @Test
    public void testMatrixRowSizeAndColumnSize()
    {
        assertEquals(2, matrixA.getColumnSize());
        assertEquals(2, matrixA.getRowSize());
    }

    @Test
    public void testMatrixElements()
    {
        assertEquals(0d, matrixA.getValueAt(0,0),0.001);
        assertEquals(1d, matrixA.getValueAt(0,1),0.001);
        assertEquals(2d, matrixA.getValueAt(1,0),0.001);
        assertEquals(3d, matrixA.getValueAt(1,1),0.001);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMatrixAfterShrinking()
    {
        matrixA.arrangeMatrix(1,1);
        assertEquals(1, matrixA.getColumnSize());
        assertEquals(1, matrixA.getRowSize());
        assertEquals(0d, matrixA.getValueAt(0,0),0.001);
        assertEquals(1d, matrixA.getValueAt(0,1),0.001);
        //throws exception
        matrixA.getValueAt(1,1);
    }

    @Test
    public void testMatrixAfterEnlarging()
    {
        matrixA.arrangeMatrix(2,3);
        assertEquals(3, matrixA.getColumnSize());
        assertEquals(2, matrixA.getRowSize());
        assertEquals(0d, matrixA.getValueAt(0,0),0.001);
        assertEquals(1d, matrixA.getValueAt(0,1),0.001);
        assertEquals(0d, matrixA.getValueAt(0,2),0.001);
    }

    @Test
    public void testTwoEqualMatricesIfTheyAreEqual()
    {
        assertEquals(0, matrixA.compareTo(matrixATwin));
    }
    @Test
    public void testTwoUnequalMatricesIfTheyAreEqual()
    {
        assertEquals(-1, matrixA.compareTo(matrixB));
        assertNotEquals(0, matrixA.compareTo(matrixB));
    }
}
