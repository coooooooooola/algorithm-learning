package com.zeburan.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class NormalHash {

    /**
     * 383. 赎金信
     * https://leetcode.cn/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, (int) map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if (!map.containsKey(c) || (int) map.get(c) <= 0) {
                return false;
            }
            map.put(c, (int) map.get(c) - 1);
        }
        return true;
    }

    /**
     * ⭐ 383. 赎金信(当字符串仅有固定字符组成时可用)
     * https://leetcode.cn/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructOpt(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if(count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
