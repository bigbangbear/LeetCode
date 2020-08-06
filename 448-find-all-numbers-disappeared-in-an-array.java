import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (list.contains(i) == false) {
                result.add(i);
            } 
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        
        for (int i = 0; i < nums.length; )  {
            int num = nums[i]; 
            
            if (num == i + 1) {
                i++;
            }else {
                if (num == -1) {
                    i++;
                    continue;
                }
                int next = nums[num-1];
                if (next == num - 1) {
                    nums[i] = -1;
                    i++;
                }else {
                    nums[num-1] = num-1;
                    nums[i] = next;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == -1) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args)  {
        int nums[] = {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
        List<Integer> list = solution.findDisappearedNumbers1(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
