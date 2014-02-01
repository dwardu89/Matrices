package com.dwardu.Matrix;

import java.util.Random;

public class Matrix implements Comparable<Matrix> {

	private double[][] values;
	private int columnSize;
	private int rowSize;

	public Matrix(int columnSize, int rowSize) {
		super();
		this.columnSize = columnSize;
		this.rowSize = rowSize;
		values = new double[rowSize][columnSize];
	}

	public Matrix(String csv, int columnSize, int rowSize) {
		this.columnSize = columnSize;
		this.rowSize = rowSize;

		String[] array = csv.split("\r\n");

		for (int i = 0; i < rowSize; i++) {
			String[] row = array[i].split(",");
			for (int j = 0; j < columnSize; j++) {
				values[i][j] = Double.parseDouble(row[i]);
			}
		}
	}

	public double[][] getValues() {
		return values;
	}

	public void setValues(double[][] values) {
		this.values = values;
	}

	/**
	 * Shrinks or enlarges the matrix, if the matrix is shrunk, data will be
	 * lost
	 * 
	 * @param row
	 *            The row.
	 * @param col
	 *            The column.
	 * 
	 * @return result
	 */
	public double getValueAt(int row, int column) {
		double result = 0;
		if (row <= rowSize && column <= columnSize) {
			result = values[row][column];
		} else
			result = Double.NaN;
		return result;
	}

	/**
	 * Sets the value at a specific point in the matrix
	 * 
	 * @param row
	 *            The row.
	 * @param col
	 *            The column.
	 * 
	 * @return result
	 */
	public boolean setValueAt(int row, int col, double value) {
		boolean result = false;
		if (row <= rowSize && col <= columnSize) {
			values[row][col] = value;
			result = true;
		}
		return result;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	/**
	 * Shrinks or enlarges the matrix, if the matrix is shrunk, data will be
	 * lost
	 * 
	 * @param newRowSize
	 * @param newColumnSize
	 */
	public void arrangeMatrix(int newRowSize, int newColumnSize) {

		double[][] tempMatrix = new double[newRowSize][newColumnSize];

		for (int i = 0; i < rowSize && i < newRowSize; i++) {
			for (int j = 0; j < columnSize && j < newColumnSize; j++) {
				tempMatrix[i][j] = values[i][j];
			}
		}
		values = tempMatrix;
		this.rowSize = newRowSize;
		this.columnSize = newColumnSize;
	}

	/**
	 * Generates random values for the matrix
	 * 
	 * @param value
	 *            The maximum value for the matrix
	 */
	public void randomizeMatrix(int value) {
		randomizeMatrix(0, value);
	}

	/**
	 * Generates random values for the matrix
	 * 
	 * @param value
	 *            The maximum value for the matrix
	 */
	public void randomizeMatrixDouble(double value) {
		randomizeMatrixDouble(0d, value);
	}

	/**
	 * Generates random values for the matrix using integer values
	 * 
	 * @param min
	 *            The minimum value for the matrix.
	 * 
	 * @param max
	 *            The maximum value for the matrix.
	 */
	public void randomizeMatrix(int min, int max) {
		Random rnd = new Random();

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				setValueAt(i, j, Math.floor(rnd.nextDouble() * (max - min + 1))
						+ min);
			}
		}
	}

	/**
	 * Generates random values for the matrix using double values
	 * 
	 * @param min
	 *            The minimum value for the matrix.
	 * 
	 * @param max
	 *            The maximum value for the matrix.
	 */
	public void randomizeMatrixDouble(double min, double max) {
		Random rnd = new Random();

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				setValueAt(i, j, rnd.nextDouble() * (max - min) + min);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringBuilder row;

		for (int i = 0; i < rowSize; i++) {
			row = new StringBuilder();
			for (int j = 0; j < columnSize; j++) {
				row.append("" + values[i][j] + " ");
			}
			sb.append(row.toString() + "\n");
		}

		return sb.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Matrix m = new Matrix(this.columnSize, this.rowSize);
		for (int i = 0; i < this.rowSize; i++) {
			for (int j = 0; j < this.columnSize; j++) {
				m.values[i][j] = this.values[i][j];
			}
		}
		return m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * @return result
	 */
	@Override
	public int compareTo(Matrix mat) {
		int result = -1;
		if (this.columnSize == mat.columnSize) {
			if (this.rowSize == mat.rowSize) {
				for (int i = 0; i < this.columnSize; i++) {
					for (int j = 0; j < this.rowSize; j++) {
						if (this.values[i][j] != mat.values[i][j]) {
							result = -1;
							return result;
						}
					}
				}
				result = 0;
				return result;
			}
		}
		if (this.columnSize != mat.columnSize || this.rowSize != mat.rowSize)
			return result;

		return result;
	}

}
