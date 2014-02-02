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
	 * Creates a lower triangular matrixs
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
	 */
	public static Matrix createDiagonal(int a[]) {
		Matrix diagonal = new Matrix(a.length, a.length);
		for (int n = 0; n < a.length; n++)
			diagonal.setValueAt(n, n, a[n]);
		return diagonal;
	}

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
	public static Matrix createSymmetricUpper(Matrix matrix) throws CloneNotSupportedException {
		if (matrix.getRowSize() == matrix.getColumnSize()) {
			Matrix symmetricMatrix  = (Matrix)matrix.clone();
			int n = matrix.getRowSize();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i > j)
						symmetricMatrix.setValueAt(i, j, matrix.getValueAt(j, i));
				}
			} 
			return symmetricMatrix;
		} else
			return null;
	}

	 public static Matrix createSymmetricLowerMatrix(Matrix matrix) throws CloneNotSupportedException
     {

         if (matrix.getRowSize() == matrix.getColumnSize())
         {
             Matrix symmetricMatrix = (Matrix)matrix.clone();
             int n = matrix.getRowSize();
             for (int i = 0; i < n; i++)
             {
                 for (int j = 0; j < n; j++)
                 {
                     if (i < j)
                         matrix.setValueAt(i, j, matrix.getValueAt(j, i));
                 }
             }
             symmetricMatrix = matrix;
             return symmetricMatrix;
         }
         else return null;
     }
	
	/*
	 * Creates a matrix with using the lower-triangular matrix
	 * 
	 * @param matrix The matrix to use to create the symmetric-lower matrix
	 * 
	 * @return symmetricMatrix The symmetric matrix, returns null if the matrix
	 * is not a square matrix.
	 */
	public static Matrix createLowerTriangular(Matrix matrix) throws CloneNotSupportedException {
		if (matrix.getRowSize() == matrix.getColumnSize()) {
			Matrix symmetricMatrix  = (Matrix) matrix.clone();
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
	  public static double getDeterminant(Matrix a)
      {
          if (a.getRowSize() == 2 && a.getColumnSize() == 2)
          {
              return getTwoByTwoDeterminant(a);
          }
          //TODO: Cater for determinants of matrices that are higher than 2x2 square matrices
          else return 0;
      }
	  
	  /*
	   * Gets the detereminant of a 2x2 matrix
	   * 
	   * @return determinant
	   */
    private static double getTwoByTwoDeterminant(Matrix a)
    {
        return a.getValueAt(0,0)*a.getValueAt(1,1) - a.getValueAt(0,1)*a.getValueAt(1,0);
    }
}
