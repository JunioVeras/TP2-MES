package java\_programs;
import java.util\*;

/**
 *
 * @author derricklin
 */
public class GET_FACTORS {
    public static List<Integer> get_factors(int n) {
        if (n == 1) {
            return Collections.emptyList();
        }
        int max = (int) Math.ceil((double) n / 2.0);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                List<Integer> prepend = new ArrayList<>(Collections.singletonList(i));
                prepend.addAll(get_factors(n / i));
                return prepend;
            }
        }
        return Collections.emptyList();
    }
}