package java_programs;
import java.util.*;

class Node {
    private Node successor;

    public Node getSuccessor() {
        return successor;
    }

    public void setSuccessor(Node successor) {
        this.successor = successor;
    }
}

public class DETECT_CYCLE {
    public static boolean detectCycle(Node node) {
        if (node == null || node.getSuccessor() == null) 
            return false;

        Node tortoise = node;
        Node hare = node;

        while (true) {
            if (hare.getSuccessor() == null)
                return false;

            tortoise = tortoise.getSuccessor();
            hare = hare.getSuccessor().getSuccessor();

            if (hare == tortoise)
                return true;
        }
    }
}