package com.nirmal.recursion;

import java.util.Arrays;

public class AnagramChecker {
    boolean areAnagrams(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        int str1Length = s1.length();
        int str2Length = s2.length();

        if (str1Length != str2Length) {
            return false;
        }

        Arrays.sort(s1.toCharArray());
        Arrays.sort(s2.toCharArray());

        for (int i = 0; i < str1Length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramChecker ac = new AnagramChecker();
        String str1 = "sample";
        String str2 = "amples";
        System.out.println("is anagram" + ac.areAnagrams(str1,str2));
    }
}
