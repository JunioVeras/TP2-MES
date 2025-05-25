package java_programs;
import java.util.*;

/**
 *
 * @author derricklin
 */
public class FLATTEN {
    public static Object flatten(Object arr) {
        if (arr instanceof List<?>) {
            List<?> narr = (List<?>) arr;
            List<Object> result = new ArrayList<>(50);
            for (Object x : narr) {
                if (x instanceof List<?>) {
                    result.addAll((List<?>) flatten(x));
                } else {
                    result.add(flatten(x));
                }
            }
            return result;
        } else {
            return flatten(arr);
        }
    }
}