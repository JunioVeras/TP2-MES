package java_programs;

import java.util.ArrayList;
import java.util.List;

public class GET_FACTORS {

    public static List<Integer> getFactors(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }

        int sqrtN = (int)Math.sqrt((double)n);

        for (long i = 2; i <= Math.min(sqrtN + 1, n); i++) {
            if (n % i == 0) {
                long factor1 = i;
                long factor2 = n / i;
                
                // Check both factors before adding them back into list
                if ((factor1!= factor2 && n % factor1 == 0 && n % factor2 == 0)
                    || (i > Math.sqrt(n)) ) { 
                    List<Integer> result = new ArrayList<>(List.of(factor1, factor2));  
                    result.addAll(getFactors((int)factor1));
                    return result;
                } else if (n % i == 0){
                    List<Integer> result = new ArrayList<>(List.of(i));
                    result.addAll(getFactors((int)(n/i)));
                    return result;
                }
            }
        }
        
        return new ArrayList<>();
    }
}