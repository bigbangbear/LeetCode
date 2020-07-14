import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    class Node {
        int left;
        int right;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tmp = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            tmp[i][0] = intervals[i][0];
            tmp[i][1] = intervals[i][1];
        }
        tmp[intervals.length][0] = newInterval[0];
        tmp[intervals.length][1] = newInterval[1];
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[]a, int[]b) {
                return a[0] - b[0];
            }
        });
        intervals = tmp;
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < intervals.length; i++) {
            if (nodes.size() == 0) {
                Node node = new Node();
                node.left = intervals[i][0];
                node.right = intervals[i][1];
                nodes.add(node);
            }else {
                Node last = nodes.get(nodes.size() - 1);
                if (intervals[i][0] > last.right) {
                    Node node = new Node();
                    node.left = intervals[i][0];
                    node.right = intervals[i][1];
                    nodes.add(node);
                }else if(intervals[i][0] == last.right) {
                    last.right = intervals[i][1];
                }else if (intervals[i][0] < last.right) {
                    if (intervals[i][1] > last.right) {
                        last.right = intervals[i][1];
                    }
                }
            }
        }

        int[][] result = new int[nodes.size()][2];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            result[i][0] = node.left;
            result[i][1] = node.right;
        }
        return result;
    }

    public static void main(String[] args)  {
        int nums[][] = {{1,2} , {3,4}, {6, 7}, {8, 10}};
        int insert[] = {4, 8};
        Solution solution = new Solution();
        int result[][] = solution.insert(nums, insert);
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1] + " ");
        }

    }
}
