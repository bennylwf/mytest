package com.test.string;

public class Permutation {

    public static void main(String[] args) {
        permutation("abc", "");
    }

    static void permutation(String str, String prefix) {

        if (str.length() == 0) {
            System.out.println(prefix);
        }
        else {
            for (int i=0; i<str.length(); i++) {
                String rem = str.substring(0, i) + str.substring( i+1);

                System.out.println(String.format("The str is %s, prefix is %s", rem, prefix + str.charAt(i)));
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
