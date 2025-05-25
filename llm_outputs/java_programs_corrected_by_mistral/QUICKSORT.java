package java_programs;
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derricklin
 */
public class QUICKSORT {
    public static ArrayList<Integer> quicksort(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return new ArrayList<Integer>();
        }

        int pivotIndex = 0;
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(pivotIndex)) {
                less.add(arr.get(i));
            } else {
                greater.add(arr.get(i));
            }
        }
        less.add(arr.get(pivotIndex));
        greater.clear();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(pivotIndex)) {
                greater.add(arr.get(i));
            }
        }
        return quickSortHelper(less, greater);
    }
    
    private static List<Integer> quickSortHelper(List<Integer> less, List<Integer> greater) {
        if (less.isEmpty() && greater.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Integer> result = null;
        if (!greater.isEmpty()) {
            result = quickSortHelper(greater, less);
        } else {
            result = quickSortHelper(less, greater);
        }
        result.add(Collections.max(less, greater));
        return result;
    }
}