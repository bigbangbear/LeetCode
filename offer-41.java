class MedianFinder {

   
    PriorityQueue<Integer> big = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            if (a < b) {
                return 1;
            }else {
                return -1;
            }
        }
    });

    PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            if (a < b) {
                return -1;
            }else {
                return 1;
            }
        }
    });
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (big.size() == 0 && small.size() == 0) {
            big.add(num);
        }else {
            if (num <= big.peek()) {
                big.add(num);
            }else {
                small.add(num); 
            }
            if (small.size() > big.size()) {
                big.add(small.poll());
            }else if (big.size() > small.size() + 1) {
                small.add(big.poll());
            }
        }
    }

    public double findMedian() {
        if (big.size() == 0) {
            return 0;
        }
        if (small.size() == big.size()) {
            return (small.peek() + big.peek()) / 2.0;
        }
        return big.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
