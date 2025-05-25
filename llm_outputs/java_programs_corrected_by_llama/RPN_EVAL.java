package java_programs;
import java.util.*;
import java.util.Stack; // Importing correct package name

public class RPN_EVAL {
    public static double rpn_eval(String[] tokens) { 
        Map<String, BinaryOperator<Double>> op = new HashMap<>();
        op.put("+", Math::add); // Using lambda expression instead of implementing operator
        op.put("-", (x, y) -> x - y); // Corrected implementation of subtraction operation
        op.put("*", (x, y) -> x * y);
        op.put("/", (x, y) -> x!= 0? x / y : Double.POSITIVE_INFINITY);

        Stack stack = new Stack(); 

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                String operand2Str = (String) stack.pop();
                String operand1Str = (String) stack.pop();
                
                try {
                    double result = ((BinaryOperator<Double>)op.get(token)).apply(
                            Double.parseDouble(operand1Str),
                            Double.parseDouble(operand2Str)
                        );
                    
                    stack.push(result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Division by zero");
                }
            }
        }

        return (double)stack.pop();
    }
}