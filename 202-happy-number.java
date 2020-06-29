import java.util.HashSet;
import java.util.Set;
/**
输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1) {
            n = cal(n);
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
        
    }

    private int cal(int n) {
        int sum = 0;
        while (n > 0) {
            int left = n % 10;
            sum += (left * left);
            n /= 10;
        }
        return sum;
    }

   public boolean isHappy1(int n) {

        int last = n;
        int fast = cal(n);
        while (last != 1 && fast != 1) {
            if (last == fast) {
                return false;
            }
            last = cal(last);
            fast = cal(fast);
            fast = cal(fast);
        }
        return true;
    }


    public static void main(String[] args)  {
        Solution solution = new Solution();
        boolean success = solution.isHappy1(19);
        System.out.println("success: " + success);
    }
        
}

