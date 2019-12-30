/**
 * 是否可以到打数组中数字为 0 的元素
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 0) {
                List<Integer> list = new ArrayList<Integer>();
                if (tryReach(arr, start, i, list)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tryReach(int[] arr, int start, int end, List<Integer> list) {
        if (start >= 0 && start < arr.length) {
            if (start == end) {
                return true;
            }else{
                if (list.contains(start)){
                    return false;
                }else{
                    list.add(start);
                    List<Integer> first = new ArrayList<Integer>();
                    first.addAll(list);
                    List<Integer> last = new ArrayList<Integer>();
                    last.addAll(list);
                    return tryReach(arr, start - arr[start], end, first) || tryReach(arr, start + arr[start], end, last);
                }
            }
        }

        return false;
    }
}



