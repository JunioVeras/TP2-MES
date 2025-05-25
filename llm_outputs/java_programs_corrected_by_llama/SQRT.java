package java_programs;

import java.util.Scanner;

public class SQRT {

    /**
     * Calculates square root using Newton's method with an optional tolerance parameter.
     * 
     * @param x The number for which we want to calculate the square root.
     * @param epsilon A small value used as a tolerance; numbers closer than this will be considered equal.
     * @return An approximation of the square root of x.
     */
    public static double sqrt(double x, double epsilon) {
        if (x < 0) {
            throw new ArithmeticException("Cannot compute square root of negative number");
        }

        double guess = x / 2d;
        while (true) {
            double betterGuess = 0.5d * (guess + x / guess);

            // Check if the difference between our current estimate and the next one is less than epsilon
            if (Math.abs(guess - betterGuess) <= epsilon) {
                break;
            } else {
                guess = betterGuess;
            }
        }

        return betterGuess;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(sqrt(9, 1e-10));
        System.out.println(sqrt(-4, 1e-10)); // This should print "ArithmeticException"
        
        scanner.close();
    }
}