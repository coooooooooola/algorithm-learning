//接雨水 https://leetcode.cn/problems/container-with-most-water/description/
package twopointers;
public class maxArea {
    public int main(int[] height) {
        if (height.length<2){
            return 0;
        }
        int index1 = 0;
        int index2 = height.length-1;
        int S = 0;
        while(index1!=index2){
            S = Math.max(S, (index2-index1) * Math.min(height[index1],height[index2]) );
            if (height[index1] > height[index2]){
                index2--;
            }else{
                index1++;
            }
        }
        return S;
    }
}