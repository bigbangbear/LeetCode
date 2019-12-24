/**
 * 少考虑一节课可以依赖多节课的情况
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer> map = convert(prerequisites);

        for (int i = 0; i < numCourses; i++){
            if (map.get(i) != null){
                Integer num = map.get(i);
                if (isCycle(num)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCycle(int num, Map<Integer, Integer> map){
        List<Integer> list = new ArrayList<Integer>();
        while(map.get(num) != null){
            if (list.contains(num)){
                return true;
            }
            list.add(num);
            num = map.get(num);
        }
        return false;
    }

    private Map<Integer, Integer> convert(int[][] prerequisites){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<prerequisites.length; i++){
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }
        return map;
    }
}
