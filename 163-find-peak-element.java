/**
 * 返回数组中的峰值
 * 思路：遍历数组，查找比左右元素都大的元素
 */
class Solution {
    public int findPeakElement(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if (num > getLeftElement(nums, i) && num > getRightElement(nums, i)){
                return i;
            }
        }
        return 0;
    }

    /**
     * 返回左边的元素，最边上返回最小值
    public int getLeftElement(int[] nums, int index){
        if(index == 0){
            return Integer.MIN_VALUE;
        } else{
            return nums[index-1];
        }
    }
    /**
     * 返回右边的元素，最边上返回最小值
     */
    public int getRightElement(int[] nums, int index){
        if(index >= nums.length - 1){
            return Integer.MIN_VALUE;
        } else{
            return nums[index+1];
        }
    }

}
