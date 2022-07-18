package editor.cn;
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1560 👎 0
	

//2022-02-22 13:54:11
public class P96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
        System.out.println(solution.numTrees(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 定义dp[i]为有i个节点时，不同的BST数量，dp[i]的递推如下，以i=5为例
         * 5个节点的BST，可以进行如下分类：
         * 1. 左子树有0个节点 + 根节点 + 右子树有4个节点，这种情况下的个数为dp[0]*dp[4]
         * 2. 左子树有1个节点 + 根节点 + 右子树有3个节点，这种情况下的个数为dp[1]*dp[3]
         * 3. 左子树有2个节点 + 根节点 + 右子树有2个节点，这种情况下的个数为dp[2]*dp[2]
         * 4. 左子树有3个节点 + 根节点 + 右子树有1个节点，这种情况下的个数为dp[3]*dp[1]
         * 5. 左子树有4个节点 + 根节点 + 右子树有0个节点，这种情况下的个数为dp[4]*dp[0]
         * 则dp[5]就是以上5中情况相加
         * @param n
         * @return
         */
        public int numTrees(int n) {
            if (n == 1) return 1;
            else if (n == 2) return 2;

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                if (i % 2 == 1){
                    dp[i] += dp[i / 2] * dp[i / 2];
                    for (int j = 0; j < i / 2; j++) {
                        dp[i] += dp[j] * dp[i - 1 - j] * 2;
                    }
                }else{
                    for (int j = 0; j < i / 2; j++) {
                        dp[i] += dp[j] * dp[i - j - 1] * 2;
                    }
                }
            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
