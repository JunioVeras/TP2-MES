package java_programs;
import java.util.*;

/**
 *
 * @author derricklin
 */
public class MAX_SUBLIST_SUM {
    public static int max_sublist_sum(int[] arr) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int x : arr) {
            maxEndingHere = maxEndingHere + x;
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}