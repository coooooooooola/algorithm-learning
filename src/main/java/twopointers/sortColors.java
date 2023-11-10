package twopointers;

/**
 * https://leetcode.cn/problems/sort-colors/
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class sortColors {
    /**
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        //bound左边都是0
        int bound = 0;
        for (int i=0;i<len;i++){
            if (nums[i] ==0){
                int temp = nums[bound];
                nums[bound]=0;
                nums[i]=temp;
                bound++;
            }
        }
        for (int i=bound;i<len;i++){
            if (nums[i] ==1){
                int temp = nums[bound];
                nums[bound]=1;
                nums[i]=temp;
                bound++;
            }
        }

    }
}
