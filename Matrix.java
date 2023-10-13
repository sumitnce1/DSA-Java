import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        char[] operators = {'+', '-'};

        // Initialize the 3x3 matrix with random values and operations
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = rand.nextInt(9) + 1; // Random numbers between 1 and 9
            }
        }

        // Generate random operations
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = matrix[i][j];
                if (j < 2) {
                    matrix[i][j + 1] = operators[rand.nextInt(2)]; // Random operator: + or -
                }
            }
        }

        // Calculate the results
        int r1 = matrix[0][0] + matrix[0][2];
        int r2 = matrix[1][0] - matrix[1][2];
        int r3 = matrix[2][0] + matrix[2][2];

        // Print the 3x3 matrix with operations and '=' symbols
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
                if (j < 2) {
                    System.out.print(" " + matrix[i][j + 1] + " ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("= = =");
            }
        }

        // Print the results
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
    }
}
