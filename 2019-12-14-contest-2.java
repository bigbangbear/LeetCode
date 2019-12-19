/**
 * Definition: remove-covered-intervals 删除区间数组列表中被包含的的区间，返回数组的长度
 * 思路：通过 Set 记录所有被包裹的区间，从而计算出剩余的区间长度
 */
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Set<Integer> removed = new HashSet<>();
        for (int i=0; i<intervals.length ; i++) {
            for (int j =0; j<intervals.length; j++){
                if (i != j && isCovered(intervals[i], intervals[j])) {
                    removed.add(i);
                }
            }
        }
        return intervals.length - removed.size();
    }

    private boolean isCovered(int[] first, int[] second) {
        if(first[0] >= second[0] && first[1] <= second[1]){
            return true;
        }
        return false;
    }
}

