package editor.cn;
//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。 
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
// Related Topics 深度优先搜索 数组 矩阵 
// 👍 156 👎 0
	

//2021-12-18 13:16:46
public class P419BattleshipsInABoard{
    public static void main(String[] args) {
        Solution solution = new P419BattleshipsInABoard().new Solution();
        // TO TEST
        char[][] board = {{'X','.','X','X','.'},
                          {'X','.','.','.','.'},
                          {'X','.','X','X','X'},
                          {'X','.','.','.','.'}};
        System.out.println(solution.countBattleships(board));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length, n = board[0].length;
            int[][] shipIDs = new int[m][n];    // 记录board上每一格的信息，如果是战舰则记录其战舰编号，从1开始编号；如果不是战舰则是0
            int shipCnt = 0;
            // 因为原先board需要考虑边界条件，所以将原始的board外围pad一层，成为一个新的newBoard
            char[][] newBoard = new char[m + 2][n + 2];
            for (int i = 0; i < m + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (i == 0 || i == m + 1 || j == 0 || j == n + 1) newBoard[i][j] = '.';
                    else newBoard[i][j] = board[i - 1][j - 1];
                }
            }

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    // 因为后续用while循环找齐整个战舰会对i、j进行修改，因此需要先将现在的i、j保存下来
                    int originalI = i, originalJ = j;
                    // 发现了一搜新战舰
                    if (newBoard[i][j] == 'X' && shipIDs[i - 1][j - 1] == 0){
                        shipIDs[i - 1][j - 1] = ++shipCnt;
                        // 按列、行寻找出整个战舰
                        while (newBoard[i + 1][j] == 'X'){
                            i++;
                            shipIDs[i - 1][j - 1] = shipCnt;
                        }
                        while (newBoard[i][j + 1] == 'X'){
                            j++;
                            shipIDs[i - 1][j - 1] = shipCnt;
                        }
                    }
                    i = originalI;
                    j = originalJ;
                }
            }
            return shipCnt;
        }
    }*/

    class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length, n = board[0].length;
            int shipCnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X'){
                        if (i == 0 && j == 0) shipCnt++;
                        else{
                            if (i == 0) {
                                 if (board[i][j - 1] == '.') shipCnt++;
                            }
                            else if (j == 0){
                                if (board[i - 1][j] == '.') shipCnt++;
                            }
                            else {
                                if (board[i - 1][j] == '.' && board[i][j - 1] == '.') shipCnt++;
                            }
                        }
                    }
                }
            }

            return shipCnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
