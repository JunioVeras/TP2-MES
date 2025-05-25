package java_programs;

import java.util.ArrayList;
import java.util.List;

class Node {
    List<String> predecessors;
    List<String> successors;
}

public class TOPological_ORDERING {

    public static ArrayList<Node> topologicalOrdering(List<Node> directedGraph) {
        ArrayList<Node> orderedNodes = new ArrayList<>();
        
        while (!directedGraph.isEmpty()) {
            boolean hasNoPredecessor = true;
            
            for (Node node : directedGraph) {
                if (node.predecessors!= null &&!node.predecessors.isEmpty()) {
                    hasNoPredecessor = false;
                    break;
                }
            }
            
            if (hasNoPredecessor) {
                Node node = directedGraph.remove(0);
                orderedNodes.add(node);
                
                // Remove nodes with no predecessors from consideration
                directedGraph.removeAll(getNodesWithNoPredecessors(directedGraph));
            } else {
                throw new RuntimeException("Circular dependency detected");
            }
        }
        
        return orderedNodes;
    }

    private static List<Node> getNodesWithNoPredecessors(List<Node> graph) {
        List<Node> result = new ArrayList<>();

        for (Node node : graph) {
            if (node.predecessors == null || node.predecessors.isEmpty()) {
                result.add(node);
            }
        }

        return result;
    }
}