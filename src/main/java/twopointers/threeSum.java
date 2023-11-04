//三数之和
package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class threeSum {

    public List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int index1 = 0; index1 < len - 2; index1++) {
            if (nums[index1] > 0) {
                break;
            }
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            int target = 0 - nums[index1];
            int index2 = index1 + 1;
            int index3 = len - 1;
            while (index2 != index3) {
                if (nums[index2] > target) {
                    break;
                }
                if ((index2 - 1 > index1) && (nums[index2 - 1] == nums[index2])) {
                    index2++;
                    continue;
                }
                if (nums[index2] + nums[index3] == target) {
                    List<Integer> item = new ArrayList();
                    item.add(nums[index1]);
                    item.add(nums[index2]);
                    item.add(nums[index3]);
                    result.add(item);
                    index2++;
                } else if (nums[index2] + nums[index3] > target) {
                    index3--;
                } else {
                    index2++;
                }
            }

        }
        return result;
    }
}