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
public class SHUNTING_YARD {
    public static List<Integer> shunting_yard(List<String> tokens) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        List<Integer> result = new ArrayList<>(tokens.size());
        Deque<Character> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.matches("[\\d]+")) {
                result.add(Integer.parseInt(token));
            } else {
                char operator = token.charAt(0);
                while (!stack.isEmpty() && precedence.get(operator) <= precedence.get(stack.peek())) {
                    result.add(stack.poll());
                }
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.poll());
        }

        return result;
    }
}