package java_programs;
import java.util.*;

public class QUICKSORT {
    public static ArrayList<Integer> quicksort(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return new ArrayList<>();
        }

        int pivot = arr.get(0);
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < pivot) {
                lesser.add(arr.get(i));
            } else if (arr.get(i) > pivot) {
                greater.add(arr.get(i));
            }
        }
        ArrayList<Integer> middle = new ArrayList<>(Collections.singletonList(pivot));
        middle.addAll(greater);
        lesser.addAll(middle);
        return lesser;
    }
}