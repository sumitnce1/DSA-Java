package org.dsajava.sumit;

import java.util.Scanner;

public class NthFibonacci {

    public static int fibonacci(long n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n find nth FibonacciNumber: ");
        long n = sc.nextLong();

        long result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
