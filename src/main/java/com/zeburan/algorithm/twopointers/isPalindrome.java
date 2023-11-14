package com.zeburan.algorithm.twopointers;

/**
 * Create by swtywang on 11/14/23 11:38 PM
 */
public class isPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().trim();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            while (start < end && !isValid(str.charAt(start))) {
                start++;
            }
            while (start < end && !isValid(str.charAt(end))) {
                end--;
            }
            if (start < end && str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isValid(Character c) {
        return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    public static void main(String[] args) {
        System.out.println(new isPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValid('p'));
    }
}
