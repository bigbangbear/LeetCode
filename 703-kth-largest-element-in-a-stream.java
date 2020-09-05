import java.util.PriorityQueue;
import java.util.Comparator;

class KthLargest {

  
    private PriorityQueue<Integer> big = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    });

    private PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    private int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        for (int i = 0; i < k && i < nums.length; i++) {
            big.add(nums[i]);
        }
        for (int i=k; i<nums.length; i++) {
            int num = nums[i];
            help(num);
       }
    }
    
    public int add(int val) {
        if (big.size() < size) {
            big.add(val);
            return big.peek();
        }
        return help(val);
    }

    private int help(int num) {
        if (num > big.peek()) {
            int top = big.poll();
            small.add(top);
            big.add(num);
        }else {
            small.add(num);
        }
        return big.peek();
    }


}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *//
