import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

class Solution {
    class Node {
        int num;
        int x;
        int y;
    }
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Node> small = new PriorityQueue<Node>(points.length, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.num - b.num;
            }
        });
        int[][] result = new int[K][2];
        for (int i = 0; i <points.length; i++) {
            Node node = new Node();
            node.num = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            node.x = points[i][0];
            node.y = points[i][1];
            small.add(node);
        }
        for (int i = 0; i < K; i++) {
            Node node = small.poll();
            result[i][0] = node.x;
            result[i][1] = node.y;
        }
        return result;
    }

}
