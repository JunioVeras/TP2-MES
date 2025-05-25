package java_programs;

import java.util.*;

public class NEXT_PALINDROME {

    public static String nextPalindrome(int[] digitList) {
        StringBuilder sb = new StringBuilder();
        
        for (int i : digitList) {
            sb.append(i).append(" ");
        }
        
        boolean foundNine = false;
        
        for (int i = sb.length() - 1; i > 0; --i) {
            char c = sb.charAt(i);
            
            if (c == '9') {
                sb.deleteCharAt(i);
                
                if (!foundNine) {
                    sb.insert(0, "10");
                    
                    foundNine = true;
                } 
                // If we've reached here it means there's no palindrome left so create one from scratch
                else {
                    sb.setCharAt(0, '1');
                    sb.setCharAt(sb.length()-1, '1');
                }
            } else {
                ++sb.charAt(i);
                
                if (i + 1 < sb.length()) {
                    ++sb.charAt(i+1);
                }
                
                break;
            }
        }
        
        if (sb.length() <= 1 ||!isPalindrome(sb)) {
            sb.reverse();
            sb.append(' ');
            sb.append(new Integer[]{1}.toArray());
            sb.append(' ');
            sb.append(new Integer[digitList.length].stream().mapToObj(x -> x).toArray()));
            sb.append(' ');
            sb.append(new Integer[]{1}.toArray());
        }
        
        return sb.substring(0, sb.length() - 1); // Remove trailing space
    }

    private static boolean isPalindrome(StringBuilder sb) {
        int start = 0;
        int end = sb.length() - 1;
        
        while (start < end) {
            if (sb.charAt(start++)!= sb.charAt(end--)) {
                return false;
            }
        }
        
        return true;
    }
}