/**
 * 合并两个有序的数组为一个数组
 * [1,2,3,0,0,0]
 * [2,5,6]
 * 解题思路：当初面试的时候遇到这道题目，扯了半天还是没有解决
 * 1. 开始的思路都是把最小的值先存在数组一，但是实现起来就有各种情况。
 * 2. 后面转换一个思路，可以把最大的值先记录下来，简化了该问题
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        int last = m + n -1;
        int index = m - 1;
        for (int i=n-1; i>=0; ){
            if (getNums(nums2, i) >= getNums(nums1, index)){
                nums1[last] = nums2[i];
                last--;
                i--;
            }else{
                nums1[last] = nums1[index];
                index--;
                last--;
            }

        }
    }

    public int getNums(int[] nums, int index) {
        if (index < 0 ){
            return Integer.MIN_VALUE;
        }else{
            return nums[index];
        }
    }

}
