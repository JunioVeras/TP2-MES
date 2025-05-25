package java_programs;
import java.util.*;

public class MAX_SUBLIST_SUM {
    public static int maxSubarraySum(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            
            if (sum > maxSoFar)
                maxSoFar = sum;
            
            if (sum < 0)
                sum = 0;
        }
        
        return maxSoFar;
    }
}