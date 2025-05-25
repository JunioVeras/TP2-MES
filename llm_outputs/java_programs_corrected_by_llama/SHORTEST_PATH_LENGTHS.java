package java_programs;

import java.util.*;

public class SHORTEST_PATH_LENGTHS {

    /**
     * 
     * @param numNodes 
     * @param lengthByEdge 
     * @return 
     */
    public static Map<List<Integer>, Integer> shortestPathLengths(int numNodes, Map<List<Integer>, Integer> lengthByEdge) {
        Map<List<Integer>, Integer> lengthByPath = new HashMap<>();

        for (int i = 0; i < numNodes; i++)
            for (int j : Arrays.copyOfRange(new int[] { 1, numNodes }, 0, numNodes))
                lengthByPath.put(Arrays.asList(i, j - 1), lengthByEdge.getOrDefault(Arrays.asList(i, j), INF));

        for (int k = 0; k < numNodes; k++)
            for (int i = 0; i < numNodes; i++)
                for (int j = 0; j < numNodes; j++)
                    lengthByPath.put(Arrays.asList(i, j),
                            Math.min(Math.min(
                                    lengthByPath.getOrDefault(Arrays.asList(i, k), INF),
                                    lengthByPath.getOrDefault(Arrays.asList(k, j), INF)
                                ),
                                sumLengths(lengthByPath.getOrDefault(Arrays.asList(i, k), INF),
                                           lengthByPath.getOrDefault(Arrays.asList(k, j), INF))));

        return lengthByPath;
    }

    static private int sumLengths(int a, int b) {
        return a!= INF && b!= INF? a + b : INF;
    }
}