package com.nirmal.strings;

public class LongestPalindrome {
    private int getLongestPalindrome(String str) {
        int len = str.length();
        boolean table[][] = new boolean[len][len];
        int maxLength = 1;
        for (int i = 0; i < len; ++i) {
            table[i][i] = true;
        }

        int start = 0 ;
        for (int i = 0; i < len - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= len; ++k) {
            for (int i = 0; i < len - k + 1 ; ++i) {
                int j = i + k - 1;
                if (table[i+ 1][j-1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if( k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        printSubStr(str, start, start + maxLength - 1);
        return maxLength;
    }

    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String str = "geegks";
        lp.getLongestPalindrome(str);
    }
}
