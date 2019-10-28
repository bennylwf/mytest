package com.test.string;

public class FullLengthSort {
    static int numChars = 26;

    public static void main(String[] args) {

       printSortedStrings(3);

    }

    static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    private static void printSortedStrings(int remaining, String prefix) {
        if (remaining ==0) {
            if(isInorder(prefix)) {
                System.out.println(prefix);
            }
        }
        else {
            for (int i=0; i<numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining -1, prefix + c);
            }
        }
    }

    static boolean  isInorder(String s) {
        for (int i=1; i<s.length(); i++) {
            int prev = ithLetter(s.charAt(i-1));
            int curr = ithLetter(s.charAt(i));
            if (prev> curr) {
                return false;
            }

        }
        return true;
    }

    static char ithLetter(int i) {
        return (char) (((int)'a') +i);
    }


}
