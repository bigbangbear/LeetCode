class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> {
            if (o1 > o2) {
                return  -1;
            }else if (o1 == o2) {
                return 0;
            }else {
                return 1;
            }
        });

        for (int i =0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[i].length; j++) {
                int num = matrix[i][j];
                if (small.size() == k) {
                    if (num > small.peek()) {
                        continue;
                    }else {
                        small.poll();
                        small.add(num);
                    }
                }else {
                    small.add(num);
                }
            }
        }
        return small.peek();
    }
}
