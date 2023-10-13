import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix = new int[7][11];
        char[] operators = {'+', '-'};

        // Initialize the matrix with random values and operations
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 11; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    matrix[i][j] = rand.nextInt(9) + 1; // Random numbers between 1 and 9
                } else if (i % 2 == 0 && j % 2 == 1) {
                    matrix[i][j] = operators[rand.nextInt(2)]; // Random operator: + or -
                } else {
                    matrix[i][j] = '=';
                }
            }
        }

        // Calculate the results
        for (int i = 0; i < 7; i += 2) {
            for (int j = 1; j < 10; j += 2) {
                if (matrix[i][j] == '+') {
                    matrix[i][j + 1] = matrix[i][j - 1] + matrix[i][j + 1];
                } else {
                    matrix[i][j + 1] = matrix[i][j - 1] - matrix[i][j + 1];
                }
            }
        }

        // Print the matrix
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
