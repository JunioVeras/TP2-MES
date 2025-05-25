package java_programs;
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derricklin
 */
public class DETECT_CYCLE {
    public static boolean detect_cycle(Node node) {
        Node hare = node;
        Node slow = node;

        while (true) {
            if (hare.getSuccessor() == null)
                return false;

            slow = slow.getSuccessor();
            hare = hare.getSuccessor().getSuccessor();

            if (hare == slow)
                return true;
        }
    }
}