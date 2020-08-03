import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    class Node{
        int left;
        int right;
        int index;
    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return null;
        }

        List<Node> nodes = new ArrayList<Node>();
        add(A, nodes, 1);
        add(B, nodes, 2);

        Collections.sort(nodes, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.left - o2.left;
            }
        });

        List<Node> result = new ArrayList<Node>();
        for (int i = 0; i < nodes.size() - 1; i++){
            Node node = nodes.get(i);
            Node next = nodes.get(i + 1);

            if (node.index == next.index) {
                continue;
            }else {
                if (node.right < next.left) {
                    continue;
                }
                Node newNode = new Node();
                newNode.left = next.left;
                newNode.right = Math.min(next.right, node.right);
                if (result.size() <= 0) {
                    result.add(newNode);
                }else {
                    Node last = result.get(result.size() - 1);
                    if (last.right >= newNode.left) {
                        last.right = newNode.right;
                    }else {
                        result.add(newNode);
                    }
                }
            }
        }
        int[][] out = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++){
            out[i][0] = result.get(i).left;
            out[i][1] = result.get(i).right;
        }
        return out;
    }

    private void add(int[][] A, List<Node> nodes, int index) {
        for (int i = 0; i < A.length; i++){
            Node node = new Node();
            node.left = A[i][0];
            node.right = A[i][1];
            node.index = index;
            nodes.add(node);
        }
    }

    public static void main(String[] args)  {
        int [][] A= {{0,2},{5,10},{13,23},{24,25}};
        int [][] B= {{1,5},{8,12},{15,24},{25,26}};
        Solution solution = new Solution();
        int [][] result = solution.intervalIntersection(A, B);
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }

    }
}
