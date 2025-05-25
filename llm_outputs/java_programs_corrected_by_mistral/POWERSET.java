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
public class POWERSET {
    public static ArrayList<ArrayList> powerset(ArrayList<Object> arr) {
        if (!arr.isEmpty()) {
            Object first = arr.get(0);
            arr.remove(0);
            List<List<Object>> rest = arr;
            List<List<Object>> restSubsets = powerset(rest);

            List<List<Object>> output = new ArrayList<>(100);
            List<List<Object>> toAdd = new ArrayList<>(100);
            toAdd.add(first);
            for (List<Object> subset : restSubsets) {
                toAdd.addAll(subset);
            }
            output.add(toAdd);

            return output;
        } else {
            List<List<Object>> emptySet = new ArrayList<>();
            emptySet.add(Collections.singletonList(null));
            return emptySet;
        }
    }
}