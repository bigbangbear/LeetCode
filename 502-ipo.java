import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Integer> projectes = new PriorityQueue<Integer>(Collections.reverseOrder());
        Set<Integer> used = new HashSet<Integer>();
        int result = W;
        while (k > 0) {
            if (used.size() < Profits.length) {
                for (int i = 0; i < Profits.length; i++) {
                    if ( !used.contains(i) && Capital[i] <= W ) {
                        projectes.add(Profits[i]);
                        used.add(i);
                        System.out.println("profit = " + Profits[i]);
                    }
                }
            }

            if (projectes.size() > 0) {
                int profit = projectes.poll();
                result += profit;
                W += profit;
                System.out.println("add = " + profit);
            }
            k--;
        }
        return result;    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p = {1, 2, 3};
        int[] c = {1, 1, 2};
        
        int result = solution.findMaximizedCapital(1, 2, p, c);
        System.out.println(result + "");
    }
}
