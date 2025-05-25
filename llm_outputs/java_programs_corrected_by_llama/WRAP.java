package java_programs;

import java.util.ArrayList;

public class WRAP {

    public static void main(String[] args) {
        System.out.println("abc".indexOf('c', 30)); 
    }

    public static ArrayList<String> wrap(String text, int cols) {
        ArrayList<String> lines = new ArrayList<>();

        String line;
        while (!text.isEmpty()) { // changed condition
            int spaceIndex = text.indexOf(' ', cols); // found index for''
            if (spaceIndex == -1) {
                spaceIndex = text.length(); // default to end of string
            }
            line = text.substring(0, spaceIndex);
            text = text.substring(spaceIndex + 1); // updated substring call
            lines.add(line);
        }

        return lines;
    }
}


Note: I've also replaced `lastIndexOf` with `indexOf`, as it seems more suitable for finding spaces within the given limit. Also, added an empty check before entering the loop instead of checking length directly which can lead into infinite loops when there's no content left in the string. The last part was just minor adjustments based on how Java handles strings.