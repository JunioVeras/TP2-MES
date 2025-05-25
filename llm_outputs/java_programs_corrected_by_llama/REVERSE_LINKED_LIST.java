package java_programs;

import java.util.*;

class Node {
    int data;
    Node successor;

    public Node(int data) {
        this.data = data;
        this.successor = null;
    }

    public void setSuccessor(Node successor) {
        this.successor = successor;
    }

    public Node getSuccessor() {
        return successor;
    }
}

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.getSuccessor() == null)
            return head;

        Node current = head;
        while (current.getSuccessor()!= null) {
            Node temp = current.getSuccessor();
            current.setSuccessor(current.getSuccessor().getSuccessor());
            temp.setSuccessor(head);
            head = current;
            current = temp;
        }
        return head;
    }
}