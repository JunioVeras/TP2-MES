package java_programs;

import java.util.Scanner;

/**
 *
 * @author derricklin
 */
public class BITCOUNT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();
        int result = bitcount(num);
        System.out.println("The number of bits needed to represent " + num + " is " + result);
    }
    
    public static int bitcount(int n) {
        int count = 0;
        while (n!= 0) {
            n = (n & (n - 1)) >> 1;
            count++;
        }
        return count;
    }
}