package java_programs;
import java.util.*;
/*
 *
 */
public class KTH {
    public static Integer kth(ArrayList<Integer> arr, int k) {
        int pivot = arr.get(0);
        List<Integer> below = new ArrayList<>(arr.size());
        List<Integer> above = new ArrayList<>(arr.size());
        for (int x : arr) {
            if (x < pivot) {
                below.add(x);
            } else if (x > pivot) {
                above.add(x);
            }
        }

        int numLess = below.size();
        int numLessOrEq = arr.size() - above.size();
        if (k < numLess) {
            return kth(below, k);
        } else if (k >= numLessOrEq) {
            return kth(above, k);
        } else {
            return pivot;
        }
    }
}