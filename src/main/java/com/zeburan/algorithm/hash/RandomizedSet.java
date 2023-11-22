package com.zeburan.algorithm.hash;

import java.util.*;

/**
 * 238. O(1)时间插入、删除和获取随机元素
 * ⭐ 考察HashMap/HashSet/数组的使用场景
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 */
class RandomizedSet {
    public Set set;

    public RandomizedSet() {
        set = new HashSet();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }

    public int getRandom() {
        ArrayList<Integer> list = new ArrayList(set);
        int randomIndex = new Random().nextInt(list.size());
        Integer randomItem = list.get(randomIndex);
        return randomItem;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class OfficialSolution {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public OfficialSolution() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

}
