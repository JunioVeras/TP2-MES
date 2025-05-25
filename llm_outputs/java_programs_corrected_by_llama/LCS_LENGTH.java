package java_programs;

import java.util.*;

public class LCS_LENGTH {
    public static Integer lcsLength(String s, String t) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

        for (int i = 0; i <= s.length(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            dp.put(i, map);

            for (int j = 0; j <= t.length(); j++) {
                map.put(j, 0);
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    if (dp.containsKey(i - 1) && dp.containsKey(j - 1)) {
                        Map<Integer, Integer> prevInternalMap = dp.get(i - 1);
                        Map<Integer, Integer> currInternalMap = dp.get(j - 1);
                        int insertValue = prevInternalMap.get(j - 1) + 1;
                        dp.get(i).put(j, insertValue);
                    } else {
                        Map<Integer, Integer> internalMap = dp.get(i);
                        internalMap.put(j, Math.max(internalMap.getOrDefault(j, 0), 1));
                        dp.get(i).put(j, internalMap.get(j));
                    }
                }
            }
        }

        if (!dp.isEmpty()) {
            int max = 0;
            for (Integer value : dp.values().stream()
                   .map(Map::values)
                   .flatMap(Collection::stream)
                   .collect(Collectors.toList())) {
                max = Math.max(max, value.stream().max(Integer::compare).orElse(0));
            }
            return max;
        } else {
            return 0;
        }
    }
}