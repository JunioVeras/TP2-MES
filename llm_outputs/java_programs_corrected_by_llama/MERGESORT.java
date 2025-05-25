package java_programs;
import java.util.*;

public class MERGESORT {

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        
        while (j < right.size())
            result.add(right.get(j++));

        while (i < left.size())
            result.add(left.get(i++));

        return result;
    }

    public static ArrayList<Integer> mergesort(ArrayList<Integer> arr) {
        if (arr.isEmpty()) 
            return arr; // Corrected condition
        
        int middle = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(middle);
        left.addAll(arr.subList(0, middle));
        left = mergesort(left);
        ArrayList<Integer> right = new ArrayList<>(arr.size()-middle-1); // Fixed size calculation
        right.addAll(arr.subList(middle+1, arr.size()));

        return merge(left, right);
    }
}