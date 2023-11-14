package com.zeburan.algorithm.Numbers;

/**
 * Create by swtywang on 11/4/23 10:30 PM
 */
public class romanToInt {
    //解法1：第一次想到的
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        boolean flag = true;
        for (int i = 0; i < len - 1; i++) {
            if (!flag) {
                flag = true;
                continue;
            }
            int cc = special("" + s.charAt(i) + s.charAt(i + 1));
            if (cc > 0) {
                result += cc;
                flag = false;

            } else {
                result += trans(s.charAt(i));
            }
        }
        if (flag) {
            result += trans(s.charAt(len - 1));
        }
        return result;
    }

    public int trans(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int special(String s) {
        switch (s) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return -1;
        }
    }

    //解法2：看了题解后做的 https://leetcode.cn/problems/roman-to-integer/solutions/39961/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
    public int romanToInt1(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            int pre = trans(s.charAt(i - 1));
            int cur = trans(s.charAt(i));
            if (pre < cur) {
                result -= pre;
            } else {
                result += pre;
            }

        }
        result += trans(s.charAt(s.length() - 1));
        return result;
    }

    public static void main(String[] args) {
        int result1 = new romanToInt().romanToInt("XXXL");
    }
}
