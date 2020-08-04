import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        List<int[]> list= new ArrayList<>();
        int i=0;
        int j=0;
        while (i < A.length && j < B.length) {
            if (A[i][0] <= B[j][0]) {
                if (A[i][1] >= B[j][0]) {
                    add(list, B[j][0], Math.min(B[j][1], A[i][1]));
                }
            }else {
                if (B[j][1] >= A[i][0]) {
                    add(list, A[i][0], Math.min(A[i][1], B[j][1]));
                }
            }
            if (A[i][1] <= B[j][1]) {
                i++;
            }else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void add(List<int[]> list, int left, int right) {
        int[] tmp = new int[2];
        tmp[0] = left;
        tmp[1] = right;
        list.add(tmp);
        System.out.println("left = " + left + ", right = " + right);
    }

    public static void main(String[] args)  {
        int [][] A= {{0,2},{5,10},{13,23},{24,25}};
        int [][] B= {{1,5},{8,12},{15,24},{25,26}};
        Solution solution = new Solution();
        int [][] result = solution.intervalIntersection(A, B);
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }

    }
}
