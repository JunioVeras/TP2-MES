package java_programs;

import java.util.*;

public class LEVENSHTEIN {

    public static int levenshtein(String source, String target) {
        if (source.isEmpty() && target.isEmpty()) {
            return 0; // Return 0 when both strings are empty
        } else if (source.isEmpty()) {
            return target.length(); // Return length of target string
        } else if (target.isEmpty()) {
            return source.length(); // Return length of source string
        }

        int[][] dp = new int[source.length() + 1][target.length() + 1];

        for (int i = 0; i <= source.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= target.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                int cost = source.charAt(i - 1) == target.charAt(j - 1)? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j] + 1,
                        Math.min(dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + cost));
            }
        }

        return dp[source.length()][target.length()];
    }
}