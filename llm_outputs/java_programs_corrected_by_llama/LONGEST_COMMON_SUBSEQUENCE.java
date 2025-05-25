package java_programs;

import java.util.*;

public class LongestCommonSubsequence {

    public static String longest_common_subsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        i:
        for (i = a.length(), j = b.length(); i > 0 && j > 0;) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                result.insert(0, a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longest_common_subsequence("ABCBDAB", "BDCABA"));
    }
}