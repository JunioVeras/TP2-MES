package java_programs;

import java.util.*;

public class KTH {

    public static Integer kth(ArrayList<Integer> arr, int k) {
        if (arr.isEmpty()) {
            throw new IndexOutOfBoundsException("Array cannot be empty");
        }
        
        int pivot = arr.get(0);
        ArrayList<Integer> below = new ArrayList<>(arr.subList(1, arr.size()));
        ArrayList<Integer> above = new ArrayList<>();
        
        for (int i = 2; i <= arr.size(); i++) {
            int x = arr.get(i-1);
            if (x < pivot) {
                below.add(x);
            } else if (x > pivot) {
                above.add(x);
            }
        }

        int num_less = below.size();
        int num_lessorEq = arr.size() - above.size();
        if (k < num_less) {
            return kth(below, k);
        } else if (k == num_less) {
            return Collections.min(arr); // Return smallest element when equal
        } else if (k >= num_less + 1) { 
            return kth(above, k-num_less-1); 
        } else {
            return pivot;
        }
    }
}