//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 96 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 0) {
            return new int[0];
        }
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int num = 1;
        for (int i=0; i<a.length; i++) {
            if (i == 0) {
                left[i] = a[i];
            }else {
                left[i] = left[i-1] * a[i];
            }
        }
        for (int i=a.length - 1; i>=0 ; i--) {
            if (i == a.length - 1) {
                right[i] = a[i];
            }else {
                right[i] = right[i+1] * a[i];
            }
        }
        int[] result = new int[a.length];
        for (int i=0; i<a.length; i++) {
            if (i == 0) {
                result[i] = right[1];
            }else if(i == a.length - 1) {
                result[i] = left[a.length - 2];
            }else {
                result[i] = left[i-1] * right[i + 1];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

