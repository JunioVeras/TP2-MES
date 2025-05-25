package java_programs;
import java.util.*;

public class LIS {
    public static int lis(int[] arr) {
        Map<Integer, Integer> ends = new HashMap<>();
        int longest = 0;

        int i = 0;
        for (int val : arr) {

            ArrayList<Integer> prefix_lengths = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : ends.entrySet()) {
                if (entry.getValue().equals(i)) continue;
                if (arr[entry.getKey()] < val) {
                    prefix_lengths.add(entry.getKey());
                } else break;
            }

            int length =!prefix_lengths.isEmpty()? Collections.max(prefix_lengths) : 0;

            if ((longest <= length && val > arr.get(ends.get(longest))) ||
                (val >= arr.get(Math.min(ends.keySet(), longest)))) {
                ends.put(length, i);
                longest = Math.max(longest, length);
            }

            i++;
        }
        return longest;
    }
}