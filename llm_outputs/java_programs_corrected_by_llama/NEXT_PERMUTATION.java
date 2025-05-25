package java_programs;

import java.util.*;

public class NEXT_PERMUTATION {

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> perm) {
        for (int i = perm.size() - 2; i >= 0; i--) {
            if (perm.get(i) > perm.get(i + 1)) {
                for (int j = perm.size() - 1; j!= i; j--) {
                    if (perm.get(j) < perm.get(i)) {
                        Collections.swap(perm, i, j);
                        reverse(perm, i);
                        return perm;
                    }
                }
            } else if (i == perm.size() - 2 && perm.get(i) == perm.get(i + 1)) {
                // If we reach here it means all elements after current element 
                // are greater than previous one so there's no permutation left
                return null;
            }
        }

        return null;
    }

    private static void reverse(ArrayList<Integer> list, int start) {
        int end = list.size() - 1;
        while (start < end) {
            Collections.swap(list, start++, end--);
        }
    }
}