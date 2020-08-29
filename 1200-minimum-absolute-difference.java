import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-1; i++) {
            int diff = arr[i+1] - arr[i];
            if (diff < min) {
                result.clear();
                result.add(Arrays.asList(arr[i], arr[i+1]));
                min = diff;
            }else if (diff == min) {
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return result;
    }
}
