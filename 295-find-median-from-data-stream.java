import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;



class MedianFinder {


    List<Integer> numbers = new ArrayList<Integer>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        numbers.add(num);
        Collections.sort(numbers);
    }

    public double findMedian() {
        if (numbers.size() == 0) {
            return 0;
        }

        if (numbers.size() % 2 == 1) {
            return numbers.get(numbers.size() / 2);
        }else {
            return (numbers.get(numbers.size() / 2) +numbers.get(numbers.size() / 2 - 1)) / 2.0; 
        }
    }


}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder1 {


    /** initialize your data structure here. */
    PriorityQueue<Integer> big = new PriorityQueue<Integer>();
    PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }

    });

    public MedianFinder1() {

    }

    public void addNum(int num) {
        small.add(num);
        int max = small.poll();
        big.add(max);
        if (big.size() > small.size()) {
            int tmp = big.poll();
            small.add(tmp);
        }
    }

    public double findMedian() {
        if (big.isEmpty() && small.isEmpty()) {
            return 0;
        }
        if ((big.size() + small.size()) % 2 == 0) {
            return (big.peek() + small.peek())/ 2.0
        }else {
            return small.peek();
        }
    }


}
