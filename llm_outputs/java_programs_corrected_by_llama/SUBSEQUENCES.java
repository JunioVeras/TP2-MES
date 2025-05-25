package java_programs;

import java.util.ArrayList;

public class SUBSEQUENCES {

    public static ArrayList<ArrayList<Integer>> subsequences(int a, int b, int k) {
        if (k == 0) {
            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(a); // changed from ArrayList to ArrayList<Integer>
            return ret;
        } else {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>(b - a + 2);
            for (int i = a; i <= b && i < b + k; i++) {
                ArrayList<ArrayList<Integer>> temp = new ArrayList(b - i + 2);
                for (ArrayList<Integer> subsequence : subsequences(i + 1, b, k - 1)) {
                    ArrayList<Integer> newSubsequence = new ArrayList<>();
                    newSubsequence.add(i);
                    newSubsequence.addAll(subsequence);
                    temp.add(newSubsequence);
                }
                ret.addAll(temp);
            }
            return ret;
        }
    }

}