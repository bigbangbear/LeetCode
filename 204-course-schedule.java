/**
 * 查找出课程依赖关系中是否有循环依赖的情况
 * DFS：深度优先搜索
 * 利用 Map 优化查询速度
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = getMap(prerequisites);
        for (int key : map.keySet()) {
            Map<Integer, Boolean> stack = new HashMap<>();
            stack.put(key, true);
            if (isCycle(key, stack, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(int key, Map<Integer, Boolean> stack, Map<Integer, List<Integer>> map) {
        List<Integer> classes = map.get(key);
        if (classes == null) {
            return false;
        }
        for (int c : classes) {
            if (stack.get(c) != null) {
                return true;
            } else {
                stack.put(c, true);
            }
            if (isCycle(c, stack, map)) {
                return true;
            } else {
                stack.remove(c);
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> getMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] cleasses = prerequisites[i];
            if (map.get(cleasses[0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(cleasses[1]);
                map.put(cleasses[0], list);
            } else {
                List<Integer> list = map.get(cleasses[0]);
                list.add(cleasses[1]);
            }
        }
        return map;
    }
}
