package editor.cn;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1099 👎 0


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//2021-12-29 15:41:39
public class P64MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        // TO TEST
        int[][] grid = {{1,3,1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            int[][] howCome = new int[m][n];    // 值为1代表从上面一格转移过来；值为0代表从左边一格转移过来
            for (int i = 1; i < m; i++) {
                howCome[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0){
                        if (dp[i - 1][j] < dp[i][j - 1]){
                            dp[i][j] = dp[i - 1][j] + grid[i][j];
                            howCome[i][j] = 1;
                        }else{
                            dp[i][j] = dp[i][j - 1] + grid[i][j];
                        }
                    }else if (i > 0){
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }else if (j > 0){
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }else{
                        dp[i][j] = grid[0][0];
                    }
                }
            }
            Deque<int[]> routes = new LinkedList<>();
            int[] curPos = {m - 1, n - 1}, dest = {0, 0};
                while (!Arrays.equals(curPos, dest)){
                routes.offerLast(curPos.clone());
                if (howCome[curPos[0]][curPos[1]] == 0){
                    curPos[1] -= 1;
                }else curPos[0] -= 1;
            }
            while (!routes.isEmpty()){
                int[] pos = routes.pollLast();
                System.out.println(grid[pos[0]][pos[1]]);
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
