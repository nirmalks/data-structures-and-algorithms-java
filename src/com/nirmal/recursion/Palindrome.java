package com.nirmal.recursion;

public class Palindrome {
    private boolean isPalindromeRec(String str, int start, int end) {
        if (start == end) {
            return true;
        }
        if(str.charAt(start) != str.charAt(end)) {
            return false;
        }
        if (start < end + 1) {
            return isPalindromeRec(str, start + 1, end - 1);
        }
        return true;
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        } else {
            return isPalindromeRec(str,0,str.length()-1);
        }
    }
    public static void main(String[] args) {
        String str = "nitinad";
        Palindrome p = new Palindrome();
        System.out.println("is palindrome" + p.isPalindrome(str));
    }
}
