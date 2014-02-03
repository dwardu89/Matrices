package com.dwardu.Matrix;

import java.io.ObjectInputStream.GetField;

public class MatrixFunction {

	/*
	 * Adds 2 matrices and returns a matrix with the addition
	 * 
	 * @return sum added matrices, returns null if dimensions don't match
	 */
	public static Matrix add(Matrix a, Matrix b) {
		Matrix sum = null;
		if (a.getRowSize() == b.getRowSize()
				&& a.getColumnSize() == b.getColumnSize()) {
			sum = new Matrix(a.getRowSize(), a.getColumnSize());
			for (int i = 0; i < a.getRowSize(); i++) {
				for (int j = 0; j < a.getColumnSize(); j++) {
					sum.setValueAt(i, j,
							a.getValueAt(i, j) + b.getValueAt(i, j));
				}
			}
			return sum;
		} else
			return sum;
	}

	/*
	 * Subtracts 2 matrices and returns a matrix with the subtraction
	 * 
	 * @return sum subtracted matrices, returns null if dimensions don't match
	 */
	public static Matrix subtract(Matrix a, Matrix b) {
		Matrix sum = null;
		if (a.getRowSize() == b.getRowSize()
				&& a.getColumnSize() == b.getColumnSize()) {
			sum = new Matrix(a.getRowSize(), a.getColumnSize());
			for (int i = 0; i < a.getRowSize(); i++) {
				for (int j = 0; j < a.getColumnSize(); j++) {
					sum.setValueAt(i, j,
							a.getValueAt(i, j) - b.getValueAt(i, j));
				}
			}
			return sum;
		} else
			return sum;
	}

	/*
	 * Multiplies matrices
	 * 
	 * @return product Returns the multiplied matrices, returns null if the
	 * matrix is not the correct dimension
	 */
	public static Matrix multiply(Matrix a, Matrix b) {
		// Checks if the dimensions are correct for the multiplication
		if (a.getColumnSize() != b.getRowSize())
			return null;

		int n = a.getColumnSize();

		Matrix product = new Matrix(a.getRowSize(), b.getColumnSize());

		for (int i = 0; i < a.getRowSize(); i++) {
			for (int j = 0; j < b.getColumnSize(); j++) {
				double prodVal = product.getValueAt(i, j);
				for (int k = 0; k < n; k++) {
					prodVal += a.getValueAt(i, k) * b.getValueAt(k, j);
				}
				product.setValueAt(i, j, prodVal);
			}
		}
		return product;
	}

	/*
	 * Multiplies a matrix by a value
	 * 
	 * @param value
	 * 
	 * @param matrix
	 * 
	 * @return product
	 */
	public static Matrix multiply(int value, Matrix matrix) {
		Matrix product = new Matrix(matrix.getColumnSize(), matrix.getRowSize());
		for (int i = 0; i < matrix.getColumnSize(); i++) {
			for (int j = 0; j < matrix.getRowSize(); j++) {
				product.setValueAt(j, i, value * matrix.getValueAt(j, i));
			}
		}
		return product;
	}

	/*
	 * Multiplies a matrix by a value
	 * 
	 * @param value
	 * 
	 * @param matrix
	 * 
	 * @return product
	 */
	public static Matrix multiply(double value, Matrix matrix) {
		Matrix product = new Matrix(matrix.getColumnSize(), matrix.getRowSize());
		for (int i = 0; i < matrix.getColumnSize(); i++) {
			for (int j = 0; j < matrix.getRowSize(); j++) {
				product.setValueAt(j, i, value * matrix.getValueAt(j, i));
			}
		}
		return product;
	}

	/*
	 * Creates a lower triangular matrix
	 */
	public static Matrix createLowerTriangularMatrix(Matrix matrix) {
		for (int i = 0; i < matrix.getRowSize(); i++) {
			for (int j = 0; j < matrix.getColumnSize(); j++) {
				if (i < j) {
					matrix.setValueAt(i, j, 0);
				}
			}
		}
		return matrix;
	}

	/*
	 * Creates an upper trianglular matrix
	 */
	public static Matrix createUpperTriangular(Matrix matrix) {
		for (int i = 0; i < matrix.getRowSize(); i++) {
			for (int j = 0; j < matrix.getColumnSize(); j++) {
				if (i > j) {
					matrix.setValueAt(i, j, 0);
				}
			}
		}
		return matrix;
	}

	/*
	 * Creates an identity Matrix
	 */
	public static Matrix identity(int size) {
		int[] ident = new int[size];
		for (int i = 0; i < size; i++) {
			ident[i] = 1;
		}
		return createDiagonal(ident);
	}

	/*
	 * Creates a diagonal matrix
	 * 
	 * @param a[] the list of integers to place in the diagonal matrix
	 * 
	 * @return the diagonal matrix
	 */
	public static Matrix createDiagonal(int a[]) {
		Matrix diagonal = new Matrix(a.length, a.length);
		for (int n = 0; n < a.length; n++)
			diagonal.setValueAt(n, n, a[n]);
		return diagonal;
	}

	/*
	 * Creates a diagonal matrix
	 * 
	 * @param a[] the list of integers to place in the diagonal matrix
	 * 
	 * @return the diagonal matrix
	 */
	public static Matrix createDiagonal(double a[]) {
		Matrix diagonal = new Matrix(a.length, a.length);
		for (int n = 0; n < a.length; n++)
			diagonal.setValueAt(n, n, a[n]);
		return diagonal;
	}

	/*
	 * Checks if the matrix in question is symmetric
	 * 
	 * @return true if matrix is symmetric, false if matrix is not symmetric.
	 */
	public static boolean isSymmetrixMatrix(Matrix matrix) {
		if (matrix.getRowSize() == matrix.getColumnSize()) {
			int n = matrix.getRowSize();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix.getValueAt(i, j) != matrix.getValueAt(j, i))
						return false;
				}
			}
		} else
			return false;
		return true;
	}

	/*
	 * Creates a matrix with using the upper-triangular matrix
	 * 
	 * @param matrix The matrix to use to create the symmetric-upper matrix
	 * 
	 * @return symmetricMatrix The symmetric matrix, returns null if the matrix
	 * is not a square matrix.
	 */
	public static Matrix createSymmetricUpper(Matrix matrix)
			throws CloneNotSupportedException {
		if (matrix.getRowSize() == matrix.getColumnSize()) {
			Matrix symmetricMatrix = (Matrix) matrix.clone();
			int n = matrix.getRowSize();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i > j)
						symmetricMatrix.setValueAt(i, j,
								matrix.getValueAt(j, i));
				}
			}
			return symmetricMatrix;
		} else
			return null;
	}

	public static Matrix createSymmetricLowerMatrix(Matrix matrix)
			throws CloneNotSupportedException {

		if (matrix.getRowSize() == matrix.getColumnSize()) {
			Matrix symmetricMatrix = (Matrix) matrix.clone();
			int n = matrix.getRowSize();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i < j)
						matrix.setValueAt(i, j, matrix.getValueAt(j, i));
				}
			}
			symmetricMatrix = matrix;
			return symmetricMatrix;
		} else
			return null;
	}

	/*
	 * Creates a matrix with using the lower-triangular matrix
	 * 
	 * @param matrix The matrix to use to create the symmetric-lower matrix
	 * 
	 * @return symmetricMatrix The symmetric matrix, returns null if the matrix
	 * is not a square matrix.
	 */
	public static Matrix createLowerTriangular(Matrix matrix)
			throws CloneNotSupportedException {
		if (matrix.isSquare() && matrix.getSize() == 2) {
			Matrix symmetricMatrix = (Matrix) matrix.clone();
			for (int i = 0; i < matrix.getRowSize(); i++) {
				for (int j = 0; j < matrix.getColumnSize(); j++) {
					if (i < j) {
						symmetricMatrix.setValueAt(i, j, 0);
					}
				}
			}
			return symmetricMatrix;
		}
		return null;
	}

	/*
	 * Gets the determinant of a matrix
	 * 
	 * @return determinant
	 */
	public static double getDeterminant(Matrix matrix) {
		if (matrix.getSize() == 1)
			return matrix.getValueAt(0, 0);
		if (matrix.getRowSize() == 2 && matrix.getColumnSize() == 2) {
			return getTwoByTwoDeterminant(matrix);
		} else {
			double sum = 0.0d;

			for (int i = 0; i < matrix.getColumnSize(); i++) {
				sum += getSign(i) * matrix.getValueAt(0, i)
						* getDeterminant(createSubMatrix(matrix, i, 0));
			}
			return sum;
		}
	}

	/*
	 * Creates a sub matrix which is used in conjunction with the getDeterminant
	 * method
	 * 
	 * @return a smaller matrix
	 */
	private static Matrix createSubMatrix(Matrix matrix, int exclude_column,
			int exclude_row) {

		Matrix newMatrix = new Matrix(matrix.getColumnSize() - 1,
				matrix.getRowSize() - 1);
		int nCol = -1;
		for (int i = 0; i < matrix.getColumnSize(); i++) {
			if (i == exclude_column)
				continue;
			nCol++;
			int nRow = -1;
			for (int j = 0; j < matrix.getRowSize(); j++) {
				newMatrix.setValueAt(++nRow, nCol, matrix.getValueAt(j, i));
			}
		}
		return newMatrix;
	}

	/*
	 * Will get the sign of a matrix, which is used for the determinant if the
	 * number is even, then the sign returned is positive, if no then its
	 * negative.
	 * 
	 * @param i index
	 * 
	 * @return 1 if positive, -1 if negative
	 */
	private static int getSign(int i) {
		if (i % 2 == 0)
			return 1;
		else
			return -1;
	}

	/*
	 * Gets the determinant of a 2x2 matrix
	 * 
	 * @return determinant
	 */
	private static double getTwoByTwoDeterminant(Matrix a) {
		return a.getValueAt(0, 0) * a.getValueAt(1, 1) - a.getValueAt(0, 1)
				* a.getValueAt(1, 0);
	}
	/*
	 * Returns the transpose of a matrix
	 */
	public static Matrix transpose(Matrix matrix)
	{
		return null;
	}
	
	public static Matrix cofactor(Matrix matrix)
	{
		Matrix c = new Matrix( matrix.getRowSize(),matrix.getColumnSize());
		
		for (int i = 0; i < matrix.getRowSize(); i++) {
			for (int j = 0; j < matrix.getColumnSize(); j++) {
				c.setValueAt(i, j, Math.pow(-1, i+j)*getDeterminant(createSubMatrix(matrix, j, i)));
			}
		}	
	return c;
	}
	
	public static Matrix inverse(Matrix matrix)
	{
		return multiply(1/getDeterminant(matrix),transpose(cofactor(matrix)));
	}
}
