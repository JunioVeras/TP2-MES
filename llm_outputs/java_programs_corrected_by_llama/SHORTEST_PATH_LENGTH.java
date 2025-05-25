package java_programs;

import java.util.*;

class Node implements Comparable<Node>{
    private String value;
    private List<Node> successors;

    public Node(String value){
        this.value = value;
        this.successors = new ArrayList<>();
    }

    public void addSuccessor(Node successor){
        this.successors.add(successor);
    }

    public boolean equals(Object obj){
        if(obj instanceof Node)
            return ((Node)obj).value.equals(this.value);
        else 
            return false;
    }

    public int hashCode(){
        return this.value.hashCode();
    }

    public int compareTo(Node other){
        return this.value.compareTo(other.value);
    }

}

public class ShortestPathLength {

    public static int shortest_path_length(Map<List<Node>, Integer> lengthByEdge, Node startNode, Node goalNode) {
        int n = lengthByEdge.size();

        Map<Node, Integer> unvisitedNodes = new HashMap<>();
        Set<Node> visitedNodes = new HashSet<>();

        unvisitedNodes.put(startNode, 0);

        while (!unvisitedNodes.isEmpty()) {
            Node node = getMinNode(unvisitedNodes);
            int distance = unvisitedNodes.get(node);
            unvisitedNodes.remove(node);

            if (node.equals(goalNode)) {
                return distance;
            }
            visitedNodes.add(node);

            for (Node nextNode : node.getSuccessors()) {
                if (visitedNodes.contains(nextNode)) {
                    continue;
                }

                if (unvisitedNodes.containsKey(nextNode)) {
                    unvisitedNodes.put(nextNode, unvisitedNodes.get(nextNode));
                } else {
                    unvisitedNodes.put(nextNode, Integer.MAX_VALUE);
                }

                int edgeWeight = lengthByEdge.getOrDefault(Arrays.asList(node, nextNode), 0);
                unvisitedNodes.put(nextNode, Math.min(unvisitedNodes.get(nextNode), unvisitedNodes.get(nextNode) + edgeWeight));
            }
        }

        return Integer.MAX_VALUE;
    }

    public static Node getMinNode(Map<Node, Integer> map) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            if(entry.getValue() < minDistance) {
                minDistance = entry.getValue();
                minNode = entry.getKey();
            }
        }
        return minNode;
    }
}


Note - I have added `equals` and `hashCode` methods into the `Node` class as they were missing. Also note that