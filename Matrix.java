import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        Random rand = new Random();
        int numRows = 3;
        int numCols = 3;

        int[][] matrix = new int[numRows][numCols];
        char[][] rowOperations = new char[numRows][numCols];
        char[][] colOperations = new char[numCols][numRows];

        // Generate random values for the matrix
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }

        // Generate random operations for rows and columns
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols - 1; j++) {
                rowOperations[i][j] = operators[rand.nextInt(2)];
                colOperations[j][i] = rowOperations[i][j];
            }
        }

        // Calculate row results
        int[] rowResults = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rowResults[i] = matrix[i][0];
            for (int j = 1; j < numCols; j++) {
                if (rowOperations[i][j - 1] == '+') {
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
                if (colOperations[j][i - 1] == '+') {
                    colResults[j] += matrix[i][j];
                } else {
                    colResults[j] -= matrix[i][j];
                }
            }
        }

        // Check if the results of row and column operations match
        boolean resultsMatch = true;
        for (int i = 0; i < numRows; i++) {
            if (rowResults[i] != colResults[i]) {
                resultsMatch = false;
                break;
            }
        }

        // Print the matrix with operations and results
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j]);
                if (j < numCols - 1) {
                    System.out.print(" " + rowOperations[i][j] + " ");
                }
            }
            System.out.print(" = ");
            System.out.print(rowResults[i]);
            System.out.println();
            if (i < numRows - 1) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(colOperations[j][i]);
                    if (j < numCols - 1) {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }

        System.out.print("=   =   =   =   =   =   =   =   =   =   =\n");

        for (int j = 0; j < numCols; j++) {
            System.out.print(colResults[j]);
            if (j < numCols - 1) {
                System.out.print("   ");
            }
        }

        if (resultsMatch) {
            System.out.println("\n\nRow and column results match.");
        } else {
            System.out.println("\n\nRow and column results do not match.");
        }
    }

    private static char[] operators = {'+', '-'};
}
