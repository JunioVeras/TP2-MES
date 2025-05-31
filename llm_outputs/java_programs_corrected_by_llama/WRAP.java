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
