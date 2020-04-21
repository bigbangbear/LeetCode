import java.util.Map;
import java.util.HashMap;

class LFUCache {

    private class Node {
        public int value;
        public long time;
    }

    private Map<Integer, Node> nodes = new HashMap<>();
    private int capacity;
    private int current;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        current = 0;
    }
    
    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.time++;
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (current >= capacity) {
            Node last = null;
            int lastKey = -1;
            for(Integer k:nodes.keySet()) {
                Node node = nodes.get(k);
                if (last == null) {
                    last = node;
                    lastKey = k;
                }else {
                    if (node.time < last.time) {
                        last = node;
                        lastKey = k;
                    }
                }
            }
            nodes.remove(lastKey);
            current--;
        }

        Node node = new Node();
        node.value = value;
        node.time = 0;
        nodes.put(key, node);
        current++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
