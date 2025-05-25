package java_programs;

import java.util.*;

public class TO_BASE {

    public static String toBase(int num, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Invalid base");
        }

        StringBuilder result = new StringBuilder();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            int remainder = num % base;
            num /= base;
            result.insert(0, alphabet.charAt(remainder));
        } while (num!= 0);

        return result.toString();
    }
}