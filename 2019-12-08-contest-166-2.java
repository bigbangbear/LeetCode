/**
 * 题目：返回用户可能的组合
 * 注意：理解题目
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        // 按照分组最大人数进行归类
        Map<Integer, List<Integer>> map= new HashMap<Integer, List<Integer>>();
        for(int i=0; i<groupSizes.length; i++){
            int size = groupSizes[i];
            if (map.containsKey(size)){
                List<Integer> list = map.get(size);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(size, list);
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(Integer size: map.keySet()){
            List<Integer> list = map.get(size);
            if (list.size() <= size){
                result.add(list);
            }else {
                // 如果超过最大值需要进行拆分
                List<Integer> tmp = new ArrayList<Integer>();
                for(int i=0; i<list.size(); i++){
                    if (i % size == 0 && i != 0) {
                        result.add(tmp);
                        tmp = new ArrayList<Integer>();
                    }
                    tmp.add(list.get(i));
                }
                if (tmp.size() > 0) {
                    result.add(tmp);
                }
            }
        }
        return result;

    }
}
