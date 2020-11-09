/**
 * 题目：输出数组，数字最多出现两次
 * 思路：快慢指针
 * 测试：[1,1,1,2,2,3]
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 2;
        int current = 2;
        int next = 2;
        int flag = 0;
        while (next < nums.length) {
            // next 为后两个的数字，如果跟当前数字相同即重复
            // 则next 往后找到不相同的数字赋值到当前指针位置
            if (nums[flag] == nums[next]) {
                next++;
                while (next < nums.length) {
                    if (nums[next] == nums[flag]) {
                        next++;
                    } else {
                        break;
                    }
                }
            }
            if (next < nums.length) {
                nums[current] = nums[next];
                current++;
                flag++;
                next++;
                length++;
            }
        }
        return length;
    }
}

 
