import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

class Solution1 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while ( list.size() > 1){
            int next = 0;
            if (m > 1) {
             next = (index + m-1) % list.size();   
            }
            System.out.print(next + " ");
            list.remove(next);
            index = next;
        }
        return list.get(0);
    }
}
/**
 * 约瑟夫环
 * 0 1 2 3 4 0 1 2 3 4
 * 3 4 0 1 3 4 0 1 (0 + 3) % 5
 * 1 3 4 1 3 4 (1 + 3) % 4
 * 1 3 1 3 (1 + 3) % 3
 * 3 (0 + 3) % 2
 * 
 */
class Solution {
    public int lastRemaining(int n, int m) {

        int index = 0;
        int nums = 2;
        for (int i = 1; i < n; i++)  {
            index = ((index + m) % nums);
            System.out.println(index);
            nums ++;
        }
        return index;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lastRemaining(5, 3);
        System.out.println(result);
    }
}
