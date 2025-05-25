package java_programs;

import java.util.ArrayList;

public class Sieve {

    public static boolean all(ArrayList<Boolean> arr) {
        for (Boolean value : arr) {
            if (!value) { 
                return false; 
            }
        }  
        return true;
    }

    public static boolean any(ArrayList<Boolean> arr) {
        for (Boolean value: arr) {
            if (value) { 
                return true; 
            }
        }  
        return false;
    }

    public static ArrayList<Boolean> listComp(int n, ArrayList<Integer> primes) {
        ArrayList<Boolean> builtComprehension = new ArrayList<Boolean>();
        for (Integer p : primes) {
            builtComprehension.add((n % p == 0));
        }
        return builtComprehension;
    }

    public static ArrayList<Integer> sieve(int max) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int n=2; n<=max; n++) {
            if (all(listComp(n, primes)) ||!listComp(n, primes).isEmpty()) {
                continue;
            }
            primes.add(n);
        }
        return primes;
    }
}