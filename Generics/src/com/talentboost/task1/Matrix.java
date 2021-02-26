package com.talentboost.task1;

public class Matrix<T> {

    private int rows;
    private int columns;

    private Object[][] matrix;

    public Matrix(int rows, int columns) {
        if(!isValidMatrix(rows, columns)) {
            throw new IllegalArgumentException("You cannot create matrix with negative rows or columns.");
        }
        this.rows = rows;
        this.columns = columns;

        matrix = new Object[rows][columns];
    }

    public boolean isSquare() {
        return rows == columns;
    }

    public Object getElementAt(int row, int column) {
        return matrix[row][column];
    }

    private boolean isValidMatrix(int rows, int columns) {
        return rows > 0 && columns > 0;
    }
}
