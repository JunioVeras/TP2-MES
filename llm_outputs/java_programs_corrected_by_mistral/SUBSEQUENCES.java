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
public class SUBSEQUENCES {
    public static ArrayList<ArrayList> subsequences(int a, int b, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList> ret = new ArrayList<>(50);
        for (int i = a; i < b + 1 - k; i++) {
            ArrayList<Integer> base = new ArrayList<>(50);
            for (ArrayList<Integer> rest : subsequences(i + 1, b, k - 1)) {
                base.add(0, i);
                base.addAll(rest);
            }
            ret.addAll(base);
        }

        return ret;
    }
}