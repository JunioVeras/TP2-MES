package java_programs;

import java.util.ArrayList;
import java.util.Collections;

public class Bucketsort {

    public static ArrayList<Integer> bucketSort(ArrayList<Integer> arr, int k) {
        ArrayList<Integer>[] counts = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            counts[i] = new ArrayList<>();
        }
        
        for (Integer x : arr) {
            if (!counts[x].isEmpty()) {
                counts[x].add(0); 
            } else {
                counts[x].add(1);
            }
        }

        ArrayList<Integer> sortedArr = new ArrayList<>(k * Collections.max(arr) + 10);
        int[] indices = new int[sortedArr.size()];
        Arrays.fill(indices, -1);

        for (ArrayList<Integer> list : counts) {
            for (int value : list) {
                if (value == 0) {
                    continue;
                }
                
                Integer minIndex = null;
                for (i = 0; i < sortedArr.size(); i++) {
                    if (indices[i]!= -1 && (minIndex == null || indices[minIndex] > indices[i])) {
                        minIndex = i;
                    }
                }
                
                sortedArr.add(i++, value);
                indices[minIndex] = values.length;
            }
            
            for (int j = 0; j <= lists.lastIndexOf(value); j++) {
                indices[j] = -1;
            }
        }

        return sortedArr.subList(0, sortedArr.size());
    }
}