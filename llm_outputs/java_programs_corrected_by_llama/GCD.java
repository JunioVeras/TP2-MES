package java_programs;

import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter second number:");
        int num2 = scanner.nextInt();

        int result = gcd(num1, num2);
        
        System.out.println("Greatest Common Divisor is " + result);
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        } else {
            return gcd(b, a % b);
        }
    }
}