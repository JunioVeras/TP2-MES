package java_programs;

import java.util.Arrays;

/**
 *
 * @author derricklin
 */
public class FIND_IN_SORTED {
    public static int binSearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {3,5,7,9};
        System.out.println("Find element " + 6 + " in array: " + Arrays.toString(arr));
        int result = find_in_sorted(arr, 6);
        System.out.println("Result: " + result);
    }
}