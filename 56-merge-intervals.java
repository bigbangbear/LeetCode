import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    class Node {
        int left;
        int right;
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[]v1, int[]v2) {
                return v1[0] - v2[0];
            }
        });
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i <intervals.length ; i++) {
            if (nodes.size() == 0) {
                Node node = new Node();
                node.left = intervals[i][0];
                node.right = intervals[i][1];
                nodes.add(node);
                continue;
            }
            Node node = nodes.get(nodes.size() - 1);
            if (node.right >= intervals[i][0]) {
                node.right = Math.max(node.right, intervals[i][1]);
                continue;
            }else {
                Node node1 = new Node();
                node1.left = intervals[i][0];
                node1.right = intervals[i][1];
                nodes.add(node1);
                continue;
            }
        }
        int [][] result = new int[nodes.size()][2];
        for (int i = 0; i < nodes.size(); i++){
            Node node = nodes.get(i);
            result[i][0] = node.left;
            result[i][1] = node.right;
        }
        return result;
    }

    public static void main(String[] args)  {
        int nums[][] = {{2,3} , {4,5}, {1, 6}};
        Solution solution = new Solution();
        int result[][] = solution.merge(nums);
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1] + " ");
        }

    }
}
