package com.zeburan.algorithm.Strings;

/**
 * Create by swtywang on 11/11/23 5:12 PM
 */
public class Strings {
    /**
     * Leetcode 28:https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
     * @param haystack
     * @param needle
     * @return
     * 自己实现indexOf
     */
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        //自己实现java的indexOf
        int len_template = needle.length();
        int len_src = haystack.length();

        if (len_src < len_template) {
            return -1;
        }
        int loopMax = len_src - len_template;
        for (int start = 0; start <= loopMax; start++) {
            int index = 0;
            for (; index < len_template && haystack.charAt(start + index) == needle.charAt(index); index++) ;
            if (index == len_template) {
                return start;
            }
        }
        return -1;
    }
}
