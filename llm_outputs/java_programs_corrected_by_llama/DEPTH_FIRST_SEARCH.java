package java_programs;

import java.util.*;

class Node {
    // Assuming some properties like value, successors...
}

public class DepthFirstSearch {

    public interface GoalCondition {
        boolean checkGoal(Node node);
    }

    public static <T extends Node> boolean depth_first_search(T startnode, T goalnode, GoalCondition condition) {
        Set<T> visited = new HashSet<>();

        class Search {
            boolean search(T node) {
                if (visited.contains(node)) {
                    return false;
                } else if (condition.checkGoal(node)) {
                    return true;
                } else {
                    for (Object successor : ((Iterable<?>) node).iterable().iterator(); successor!= null &&!((Iterable<?>)successor).isEmpty(); successor= ((Iterable<?>)successor).iterator().next() ) {
                        if (search((T) successor)) { 
                            return true; 
                        }
                    }
                }
                return false;
            }
        };

        Search s = new Search();
        return s.search(startnode);
    }
}