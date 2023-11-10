package com.zeburan.algorithm.twopointers;

/**
 * Create by swtywang on 11/11/23 4:15 PM
 */

/**
 * Note:
 * 删除有序数组的重复项，快指针fast表示已检查的元素个数，每次遍历是nums[fast]为待检查元素；
 * 慢指针slow表示已保留的元素个数，每次遍历时nums[slow]表示下一个要保留的元素存放的位置，nums[slow-1]是当前最后一个保留的元素
 * 只需要判断nums[fast]是否和nums[slow-x]相等（x代表题目要求的相同元素最大数）
 */
public class removeDuplicates {
    //Leetcode 26: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
    public int removeDuplicatesOne(int[] nums) {
        int slow = 1;
        int fast = 1;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    //Leetcode 80: https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
    public int removeDuplicatesTwo(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        //慢指针，表示已保留的数组元素个数，nums[slow-1]表示已保留的最后一个元素，slow也表示即将要保留的位置
        int slow = 2;
        //快指针，表示已检查的元素个数
        int fast = 2;
        for (fast = 2; fast < nums.length; fast++) {
            //如果当前要检查的元素nums[fast]不等于nums[slow-2]，那么表示这个元素要被保留
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
