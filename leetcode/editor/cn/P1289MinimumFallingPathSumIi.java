package editor.cn;
//给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 请你返回非零偏移下降路径数字和的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length == arr[i].length <= 200 
// -99 <= arr[i][j] <= 99 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 58 👎 0
	

//2022-01-05 22:34:23
public class P1289MinimumFallingPathSumIi{
    public static void main(String[] args) {
        Solution solution = new P1289MinimumFallingPathSumIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            int[][] dp = new int[n][n];

            dp[0] = grid[0];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = findMin(dp[i - 1], j) + grid[i][j];
                }
            }
            return findMin(dp[n - 1], -1);
        }

        private int findMin(int[] nums, int x) {
            int rst = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i == x) continue;
                rst = Math.min(rst, nums[i]);
            }
            return rst;
        } 
    }
//leetcode submit region end(Prohibit modification and deletion)

}
