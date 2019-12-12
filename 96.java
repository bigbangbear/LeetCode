/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * BST: 二叉搜索树：
 * 一棵空树
 * 或者
 * 不为空
 *    如果它的左子树存在则左子树上所有的节点都小于根节点
 *    如果右子树存在则右子树的所有节点都大于根节点。不存在键值相同的节点
 * 动态规划科普文章：[链接](https://juejin.im/post/5a29d52cf265da43333e4da7)
 *    动态规划:分阶段求解决策问题的数学思想
 *    经典问题：爬楼梯问题
 *    重要的概念：最优子结构、边界、状态转移公式
 *
 */

/**
 * 递归的解法
 * 不是通过 DP 性能还是很差
 * 看了一下提交4年前就做过这道题目，但是那会没有解出来。唉，重算是学习了一下 DP
 */
class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (numTrees(i - 1) + numTrees(n - 1));
        }
        return sum;
    }
}

/**
 * 看了答案的 DP 解法，通过空间换取时间，性能提高许多。
 * 通过数组记录前面的记录计算获取
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            for (int root = 0; root < index; root++) {
                dp[index] += dp[root] * dp[index - root - 1];
            }
        }
        return dp[n];
    }
}
