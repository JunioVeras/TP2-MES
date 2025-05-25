package java_programs;
import java.util.*;
import java.util.ArrayDeque;

class Node {
}

public class BREADTH_FIRST_SEARCH {

    public static Set<Node> visitedNodes = new HashSet<>();

    public static boolean breadth_first_search(Node startNode, Node goalNode) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(startNode);

        visitedNodes.add(startNode);

        while (!queue.isEmpty()) { 
            Node node = queue.pollFirst(); 

            if (node == goalNode) {
                return true;  
            } else {
                for (Object successorNode : node.getSuccessors()) {
                    if (!visitedNodes.contains((Node)successorNode)) {
                        queue.offerFirst((Node)successorNode);  
                        visitedNodes.add((Node)successorNode);  
                    }
                }
            }
        }
        return false;
    }
}