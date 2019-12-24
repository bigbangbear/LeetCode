// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    List<Integer> nums = new ArrayList<Integer>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        while (iterator.hasNext()){
            nums.add(iterator.next());
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (nums.size() > 0) {
            return nums.get(0);
        }else{
            return null;
        }
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(nums.size() > 0){
            return nums.remove(0);
        }else{
            return null;
        }
	}

	@Override
	public boolean hasNext() {
	   return nums.size() > 0; 
	}
}
