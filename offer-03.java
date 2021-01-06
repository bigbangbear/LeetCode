import java.util.Set;
import java.util.HashSet;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums) {
            if (set.contains(num)) {
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
}
