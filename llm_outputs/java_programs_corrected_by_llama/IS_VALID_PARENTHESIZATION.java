package java_programs;

import java.util.*;

public class IS_VALID_PARENTHESIZATION {

    public static boolean isValidParenthesization(String parentheses) {
        int depth = 0;
        for (char c : parentheses.toCharArray()) {
            switch (c) {
                case '(':
                    depth++;
                    break;
                case ')':
                    if (depth == 0) {
                        return false;
                    }
                    depth--;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid character '" + c + "' in parentheses.");
            }
        }
        return depth == 0;
    }

}