package com.zeburan.algorithm.twopointers;

/**
 * Create by swtywang on 11/15/23 9:10 PM
 * 双指针- 快慢指针思路一致
 */
public class ArrayMove {
    /**
     * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     * 有序数组的合并
     * 双指针：indexM-nums1倒序遍历，indexM右侧的为已合并的元素；
     * indexN-nums2倒序遍历，indexN右侧的为已合并的元素
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = m - 1;
        int indexN = n - 1;
        int pointer = m + n - 1;
        while (indexN >= 0 && indexM >= 0) {
            if (nums2[indexN] > nums1[indexM]) {
                nums1[pointer] = nums2[indexN];
                indexN--;
            } else {
                nums1[pointer] = nums1[indexM];
                indexM--;
            }
            pointer--;
        }
        while (indexN >= 0) {
            nums1[pointer--] = nums2[indexN--];
        }
    }

    /**
     * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
     * 删除数组中值为val的元素
     * 双指针：快指针- 遍历的索引； 慢指针 - 已处理好的元素个数
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     * 删除数组重复项
     * 双指针：快指针- 遍历的索引； 慢指针 - 已处理好的元素个数
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesI(int[] nums) {
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * 删除数组重复项II
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesII(int[] nums) {
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
