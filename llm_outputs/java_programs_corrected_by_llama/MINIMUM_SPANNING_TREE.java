package java_programs;

import java.util.*;

class WeightedEdge implements Comparable<WeightedEdge> {
    int id;
    Node node1;
    Node node2;
    double weight;

    public WeightedEdge(Node node1, Node node2, double weight) {
        this.id = id++;
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge other) {
        return Double.compare(this.weight, other.weight);
    }
}

interface Node {}

public class MINIMUM_SPANNING_TREE {

    public static Set<WeightedEdge> minimum_spanning_tree(List<WeightedEdge> weightedEdges) {
        Map<Node, Set<Node>> groupByNode = new HashMap<>();
        Set<WeightedEdge> mst = new HashSet<>();

        Collections.sort(weightedEdges);

        for (WeightedEdge edge : weightedEdges) {
            Node u = edge.node1;
            Node v = edge.node2;
            if (!groupByNode.containsKey(u)) {
                groupByNode.put(u, new HashSet<>());
            }
            if (!groupByNode.containsKey(v)) {
                groupByNode.put(v, new HashSet<>());
            }

            if (!groupByNode.get(u).contains(v) &&!groupByNode.get(u).equals(groupByNode.get(v))) {
                mst.add(edge);
                groupByNode = mergeGroups(groupByNode, u, v);
            }
        }
        return mst;
    }

    private static Map<Node, Set<Node>> mergeGroups(
            Map<Node, Set<Node>> groupByNode,
            Node vertex_u,
            Node vertex_v) {
        Set<Node> vertex_u_span = groupByNode.get(vertex_u);
        vertex_u_span.addAll(groupByNode.get(vertex_v));
        groupByNode.remove(vertex_v); // Remove the unnecessary entry
        return groupByNode;
    }
}