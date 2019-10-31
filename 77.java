
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i + k <=n; i++){
            result.addAll(solve(n, k, 1));
        }
        return result;
    }
    private void solve(int n, int k, int index) {
        if (k == 1){
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=index; i<=n; i++){
                List<Integer> list = Arrays.asList(i);
                temp.add(list);
            }
            return temp;
        }else{
            Lsit<List<Integer>> temp = solve(n, k-1, index + 1);
            for(List<Integer> list :temp){
                list.add(index);
            }
            return temp;
        }

    }
}
