package java_programs;

import java.util.*;

public class PossibleChange {

    public static int possibleChange(int[] coins, int total) {
        if (coins.length == 0 || total <= 0) {
            return 0;
        } else if (total > 0 && total >= coins[0]) {
            return 1;
        } else {
            int first = coins[0];
            int[] rest = getRemainingCoins(coins, 1);

            return possibleChange(rest, total - first) +
                   possibleChange(getRemainingCoins(coins, 2), total);
        }
    }

    private static int[] getRemainingCoins(int[] coins, int start) {
        int length = coins.length - start;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = coins[start + i];
        }

        return result;
    }
}