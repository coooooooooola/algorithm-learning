package com.zeburan.algorithm.twopointers;

/**
 * Create by swtywang on 11/15/23 12:31 AM
 */
public class isSubSequence {
    public boolean isSubsequence(String s, String t) {
        int slow = 0;
        for (int i = 0; i < t.length(); i++) {
            if (slow == s.length()) {
                return true;
            }
            if (t.charAt(i) == s.charAt(slow)) {
                slow++;
            }
        }
        return slow == s.length();
    }
}
