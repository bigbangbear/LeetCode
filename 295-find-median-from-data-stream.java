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
