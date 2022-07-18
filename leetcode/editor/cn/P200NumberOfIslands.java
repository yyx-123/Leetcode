package editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1458 👎 0
	

//2021-12-18 14:24:22
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        System.out.println(solution.numIslands(grid));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] grid;
        int m, n;

        public int numIslands(char[][] grid) {
            this.m = grid.length;
            this.n = grid[0].length;
            int cnt = 0;
            this.grid = grid;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1'){
                        dfs(i, j);
                        cnt++;
                    }

                }
            }

            return cnt;
        }

        private void dfs(int i, int j){
            if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1'){
                return;
            }

            grid[i][j] = '2';

            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
