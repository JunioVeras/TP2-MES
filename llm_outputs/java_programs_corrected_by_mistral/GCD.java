package java_programs;
import java.util.*;

/**
 *
 * @author derricklin
 */
public class GCD {

    public static int gcd(int a, int b) {
        while (b!= 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}