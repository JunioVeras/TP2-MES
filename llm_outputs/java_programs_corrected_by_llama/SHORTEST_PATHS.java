package java_programs;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Node implements Comparable<Node>{
    private String value;
    private double distance;

    public Node(String value){
        this.value = value;
        this.distance = Double.POSITIVE_INFINITY;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public double getDistance(){
        return distance;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance > o.distance)
            return 1;
        else if(this.distance == o.distance)
            return 0;
        else
            return -1;
    }
}

class WeightedEdge{
    private Node node1;
    private Node node2;
    private double weight;

    public WeightedEdge(Node node1, Node node2, double weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public Node getNode1(){
        return node1;
    }

    public Node getNode2(){
        return node2;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
}

public class ShortestPaths {

    // Define Infinite as a large enough value. This value will be used
    // for nodes not connected to each other
    final static double INF = Double.POSITIVE_INFINITY;

    public static Map<String, Double> shortest_paths(Node source, List<WeightedEdge> weight_by_edge) {
        Map<String, Double> weight_by_node = new HashMap<>();
        for (Node node : weight_by_edge.stream().map(e -> e.getNode1()).distinct()){
            weight_by_node.put(node.getValue(), INF);
        }
        
        for (WeightedEdge edge : weight_by_edge) {
            weight_by_node.put(edge.getNode1().getValue(), 
                    Math.min(weight_by_node.get(edge.getNode1().getValue()), 
                             edge.getWeight() + weight_by_node.get(edge.getNode2().getValue())));
            
            weight_by_node.put(edge.getNode2().getValue(), 
                    Math.min(weight_by_node.get(edge.getNode2().getValue()), 
                             edge.getWeight() + weight_by_node.get(edge.getNode1().getValue())));

        }
        return weight_by_node;
    }
}