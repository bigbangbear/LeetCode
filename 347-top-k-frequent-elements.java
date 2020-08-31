import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    class Node {
        int num;
        int size;
    }
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Node> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).size++;
            }else {
                Node node = new Node();
                node.size = 1;
                node.num = nums[i];
                map.put(nums[i], node);
            }
        }
        List<Node> nodes = new ArrayList<Node>(map.values());
        
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.size - o1.size;
            }
        });
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print("num" + nodes.get(i).num + " " + nodes.get(i).size + " ");
        }
        Set<Integer> result = new HashSet<>();
        int first = nodes.get(0).size;
        int j = 0;
        for (int i = 0; i < k; i++) {
            result.add(nodes.get(i).num);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args)  {
        int[] nums = {4,1,-1,2,-1,2,3};
        Solution solution = new Solution();
        int [] result = solution.topKFrequent(nums, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
