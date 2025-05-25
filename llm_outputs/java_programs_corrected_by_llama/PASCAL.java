package java_programs;

import java.util.ArrayList;

public class Pascal {

    public static ArrayList<ArrayList<Integer>> pascal(int n) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        ArrayList<Integer> init = new ArrayList<>(Collections.singletonList(1));
        
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int left, right;
                if (j == 0 || j == i - 1) {
                    left = right = 1;
                } else {
                    left = rows.get(i - 1).get(j - 1);
                    right = rows.get(i - 1).get(j);
                }
                row.add(left + right);
            }
            rows.add(new ArrayList<>(row)); // Use constructor instead of add()
        }

        return rows;
    }

    public static void main(String[] args) {
        System.out.println(pascal(10));
    }
}