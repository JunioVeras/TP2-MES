package java_programs;

public class BITCOUNT {
    /**
     * Returns the number of bits set in the binary representation of n.
     * 
     * This function uses bitwise operations to achieve O(log(n)) time complexity,
     * which makes it more efficient than other methods for large numbers.
     * 
     * @param n The input integer.
     * @return The number of bits set in the binary representation of n.
     */
    public static int bitCount(int n) {
        int count = 0;
        while ((n & 1) == 1) { // Check if least significant bit is 1
            n >>= 1;         // Right shift by one place
            count++;          // Increment counter
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitCount(15)); // Example usage
    }
}