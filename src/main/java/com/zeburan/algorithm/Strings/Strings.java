package com.zeburan.algorithm.Strings;

/**
 * Create by swtywang on 11/11/23 5:12 PM
 */
public class Strings {
    /**
     * Leetcode 28:https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
     *
     * @param haystack
     * @param needle
     * @return 自己实现indexOf
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

    /**
     * 58. 最后一个单词的长度 - 普通解法
     * https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (!s.trim().isEmpty()) {
            String[] strList = s.trim().split(" ");
            return strList[strList.length - 1].length();
        }
        return 0;
    }

    /**
     * ⭐ 58. 最后一个单词的长度 - 优化解法
     * https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param s
     * @return
     */
    public int lengthOfLastWordI(String s) {
        String s1 = s.trim();
        int len = s1.length();

        for (int i = len - 1; i >= 0; i--) {
            if (s1.charAt(i) == ' ') {
                return len - 1 - i;
            }
        }
        return len;
    }


    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (int i=1;i<strs.length;i++){
            result = prefix(result, strs[i]);
            if (result.isEmpty()){
                break;
            }
        }
        return result;
    }

    public String prefix(String s1, String s2) {
        int index = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int minLength = Math.min(len1, len2);
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.substring(0,minLength);
    }
}
