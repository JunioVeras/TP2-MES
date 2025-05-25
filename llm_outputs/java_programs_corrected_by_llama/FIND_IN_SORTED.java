package java_programs;

import java.util.Arrays;

public class FIND_IN_SORTED {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.binarySearch(sortedArray, 3)); 
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // sort array before searching
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target)
                return mid;
            
            else if (arr[mid] < target)
                left = mid + 1;
                
            else
                right = mid - 1;
        }
        
        return ~left; // equivalent to returning -1 when element is not found
    }
}