package java_programs;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;

public class SHUNTING_YARD {

    public static List<Integer> shuntingYard(ArrayList<Object> tokens) {
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        ArrayList<Integer> rpnTokens = new ArrayList<>(100);
        ArrayDeque<String> opStack = new ArrayDeque<>();

        for (Object token : tokens) {
            if (token instanceof Integer || token instanceof Double) {
                rpnTokens.add((int) ((Number) token).doubleValue());
            } else {
                String operator = (String) token;
                while (!opStack.isEmpty() && precedence.get(operator) <= precedence.get(opStack.peek())) {
                    rpnTokens.add(rpnTokens.size(), opStack.poll());
                }
                opStack.push(operator);
            }
        }

        while (!opStack.isEmpty()) {
            rpnTokens.add(rpnTokens.size(), opStack.poll());
        }

        return rpnTokens;
    }
}