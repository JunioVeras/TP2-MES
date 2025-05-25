package java_programs;

import java.util.ArrayList;
import java.util.List;

public class POWERSET {

    public static List<List<Object>> powerset(List<Object> arr) {
        if (!arr.isEmpty()) {
            Object first = arr.get(0);
            arr.subList(1, arr.size()).clear();
            List<Set<Object>> rest_sets = powerset(arr);

            List<List<Object>> output = new ArrayList<>();
            Set<Object> current_subset = new HashSet<>(Collections.singletonList(first));
            for (Set<Object> set : rest_sets) {
                current_subset.addAll(set);
                output.add(new ArrayList<>(current_subset));
            }

            return output;
        } else {
            List<List<Object>> empty_set = new ArrayList<>();
            empty_set.add(Collections.emptyList());
            return empty_set;
        }
    }

}