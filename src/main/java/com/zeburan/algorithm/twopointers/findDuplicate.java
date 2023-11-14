package com.zeburan.algorithm.twopointers;

//https://leetcode.cn/problems/find-the-duplicate-number/description/
public class findDuplicate {
    /**
     * 我们对 nums\textit{nums}nums 数组建图，每个位置 iii 连一条 i→nums[i]i\rightarrow \textit{nums}[i]i→nums[i] 的边。由于存在的重复的数字 target\textit{target}target，因此 target\textit{target}target 这个位置一定有起码两条指向它的边，因此整张图一定存在环，且我们要找到的 target\textit{target}target 就是这个环的入口，那么整个问题就等价于 142. 环形链表 II。
     *
     * 我们先设置慢指针 slow\textit{slow}slow 和快指针 fast\textit{fast}fast ，慢指针每次走一步，快指针每次走两步，根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，此时我们再将 slow\textit{slow}slow 放置起点 000，两个指针每次同时移动一步，相遇的点就是答案。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
