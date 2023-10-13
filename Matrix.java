import java.util.Random;

public class MatrixOperations {

    private static char[] operators = {'+', '-'};

    private static void generateMatrix(int numRows, int numCols) {
        Random rand = new Random();

        int[][] matrix = new int[numRows][numCols];
        char[][] rowOpr = new char[numRows][numCols];
        char[][] colOpr = new char[numCols][numRows];

        // Generate random values
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }

        // Generate random rows columns
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols - 1; j++) {
                rowOpr[i][j] = operators[rand.nextInt(2)];
                colOpr[j][i] = rowOpr[i][j];
            }
        }

        // Calculate row results
        int[] rowResults = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rowResults[i] = matrix[i][0];
            for (int j = 1; j < numCols; j++) {
                if (rowOpr[i][j - 1] == '+') {
                    rowResults[i] += matrix[i][j];
                } else {
                    rowResults[i] -= matrix[i][j];
                }
            }
        }

        // Calculate column results
        int[] colResults = new int[numCols];
        for (int j = 0; j < numCols; j++) {
            colResults[j] = matrix[0][j];
            for (int i = 1; i < numRows; i++) {
                if (colOpr[j][i - 1] == '+') {
                    colResults[j] += matrix[i][j];
                } else {
                    colResults[j] -= matrix[i][j];
                }
            }
        }

        // Calculate the final result
        int finalResult = 0;
        for (int j = 0; j < numCols; j++) {
            finalResult += colResults[j];
        }

        // Print the matrix with operations and results
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j]);
                if (j < numCols - 1) {
                    System.out.print(" " + rowOpr[i][j] + " ");
                }
            }
            System.out.print(" = ");
            System.out.print(rowResults[i]);
            System.out.println();
            if (i < numRows - 1) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(colOpr[j][i]);
                    if (j < numCols - 1) {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }

        System.out.println("=   =   =   =");

        for (int j = 0; j < numCols; j++) {
            System.out.print(colResults[j]);
            if (j < numCols - 1) {
                System.out.print("  ");
            }
        }

        System.out.println();

        System.out.println("Final Result: " + finalResult);
    }

    public static void main(String[] args) {
        generateMatrix(3, 3);
    }
                }
