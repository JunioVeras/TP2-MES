package java_programs;
import java.util.*;

public class FIND_FIRST_IN_SORTED {

    public static int find_first_in_sorted(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1; // changed from arr.length

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == x && ((mid == 0) || (arr[mid - 1]!= x))) { 
                return mid;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1; // changed from mid
            }
        }

        return -1;
    }
}