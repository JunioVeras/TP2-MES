package java_programs;

import java.util.*;

public class Flatten {

    public static Object flatten(Object array) {
        if (array instanceof List) {
            List<Object> list = (List<Object>) array;
            List<Object> result = new ArrayList<>();
            for (Object element : list) {
                if (element instanceof List) {
                    result.addAll(flush(element));
                } else {
                    result.add(element);
                }
            }
            return result;
        } else {
            throw new RuntimeException("Input must be an instance of List");
        }
    }

    private static <T> List<T> flush(List<T> list) {
        List<T> result = new ArrayList<>(list.size());
        for (T t : list) {
            if (t instanceof List) {
                result.addAll(flush((List<?>) t));
            } else {
                result.add(t);
            }
        }
        return result;
    }
}