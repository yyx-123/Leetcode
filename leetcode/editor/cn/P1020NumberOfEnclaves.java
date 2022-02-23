package editor.cn;
//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 113 👎 0
	

//2022-02-12 12:56:47
public class P1020NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new P1020NumberOfEnclaves().new Solution();
        // TO TEST
        int[][] grid = {{0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0,0,0,0}};
        System.out.println(solution.numEnclaves(grid));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        boolean[][] visited;

        int[][] grid;

        int m, n;
        
        public int numEnclaves(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;
            visited = new boolean[m][n];

            for (int i = 0; i < n; i++) {
                if (grid[0][i] == 1 && !visited[0][i]){
                    dfs(0, i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (grid[m - 1][i] == 1 && !visited[m - 1][i]){
                    dfs(m - 1, i);
                }
            }
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1 && !visited[i][0]){
                    dfs(i, 0);
                }
            }
            for (int i = 0; i < m; i++) {
                if (grid[i][n - 1] == 1 && !visited[i][n - 1]){
                    dfs(i, n - 1);
                }
            }

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]){
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void dfs(int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]){
                return;
            }

            visited[i][j] = true;
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j - 1);
            dfs(i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
