class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Map<Integer, Integer> nod = new HashMap<>();
        Set<Integer> order = new LinkedHashSet<>();
        boolean[] used = new boolean[prerequisites.length];
        int use = 0;
        for (int i=0; i< prerequisites.length; i++) {
            int left = prerequisites[i][0];
            int right = prerequisites[i][1];

            if (nod.containsKey(left)) {
                nod.put(left, nod.get(left) + 1);
            }else {
                nod.put(left, 1);
            }
            System.out.println(left + ":" + nod.get(left));
        }

        while(use < prerequisites.length) {
            int current = use;
            for (int i=0; i<prerequisites.length; i++) {
                if (used[i]) {
                    continue;
                }
                int left = prerequisites[i][0];
                int right = prerequisites[i][1];
                if (!nod.containsKey(right)) {
                    used[i] = true;
                    use++;
                    order.add(right);
                    if (nod.get(left) <= 1) {
                        nod.remove(left);
                        order.add(left);
                    }else{
                        nod.put(left, nod.get(left) - 1);
                    }
                }
            }
            if (current == use) {
                return new int[0];
            }
        }
        int plus = 0;
        for (int i: order) {
            result[plus] = i;
            plus++;
        }
        
        for( int i = 0; i < numCourses; i++) {
            if (!order.contains(i)) {
                result[plus] = i;
                plus++;
            }
        }
        return result;

    }
}
