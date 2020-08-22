import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> small = new PriorityQueue<Integer>();
        PriorityQueue<Integer> big = new PriorityQueue<Integer>(Collections.reverseOrder());

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (big.size() == 0 || nums[i] <= big.peek()) {
                big.add(nums[i]);
            }else {
                small.add(nums[i]);
            }
            balance(small, big);
            if (i >= k - 1) {
                if (((small.size() + big.size()) % 2) == 0) {
                    long num = (long)big.peek() + (long)small.peek();
                    result[i - k + 1] = ((num)/ 2.0);
                }else {
                    result[i - k + 1] = (big.peek() * 1.0);
                }

                System.out.print("a=" + big.peek() + " b=" + small.peek() );
                System.out.println();
                int remove = nums[i - k + 1];
                if (remove > big.peek()) {
                    small.remove(remove);
                }else {
                    big.remove(remove);
                }
                balance(small, big);

            }

        }

        return result;
    }

    private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> big) {
        if (big.size() == small.size()  || big.size() == small.size() +1) {
            return;
        }
        if (big.size() > small.size() + 1) {
            small.add(big.poll());
        }else {
            big.add(small.poll());
        }
    }

    public static void main(String[] args)  {
        int [] nums = {2147483647, 2147483647};
        Solution solution = new Solution();
        double[] result = solution.medianSlidingWindow(nums, 2);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
