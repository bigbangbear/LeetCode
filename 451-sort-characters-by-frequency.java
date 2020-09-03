import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    class Node {
        Character c; 
        int size;
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return b.size - a.size;
            }
        });

        for (Character c: map.keySet()) {
            Node node = new Node();
            node.c = c;
            node.size = map.get(c);
            priorityQueue.add(node);
        }

        StringBuilder sb = new StringBuilder();
        while ( priorityQueue.size() > 0) {
            Node node = priorityQueue.poll();
            for (int i=0; i<node.size; i++) {
                sb.append(node.c);
            }
        }

        return sb.toString();
    }
}
