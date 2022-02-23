package editor.cn;
//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。 
//
// 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 
//的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。 
//
// 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。 
//
// 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj]
// 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个
//方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。 
//
// 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//输出：[1,0]
//解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）
//。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
//
//第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
//
// 
//
// 示例 2： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//输出：[1,1]
// 
//
// 示例 3： 
//
// 
//输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//输出：[1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 109 
// 0 <= lamps.length <= 20000 
// 0 <= queries.length <= 20000 
// lamps[i].length == 2 
// 0 <= rowi, coli < n 
// queries[j].length == 2 
// 0 <= rowj, colj < n 
// 
// Related Topics 数组 哈希表 
// 👍 60 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//2022-02-08 09:46:08
public class P1001GridIllumination{
    public static void main(String[] args) {
        Solution solution = new P1001GridIllumination().new Solution();
        // TO TEST
        int[][] lamps = {{0, 0}, {0, 4}}, queries = {{0, 4}, {0, 1}, {1, 4}};
        int[] rst = solution.gridIllumination(5, lamps, queries);
        System.out.println(123);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {

        int n;

        short[][] grid;

        boolean[][] turnedOn;

        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            this.n = n;
            grid = new short[n][n];
            turnedOn = new boolean[n][n];
            // 初始化，点亮所有的灯
            for (int[] lamp : lamps) {
                turn(lamp[0], lamp[1], true);
            }
            // 依次查询并关灯
            int[] rst = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];

                rst[i] = grid[query[0]][query[1]] > 0 ? 1 : 0;
                turnOffRange(query[0], query[1]);
            }
            return rst;
        }

        private void turnOffRange(int i, int j) {
            turn(i - 1, j - 1, false);
            turn(i - 1, j, false);
            turn(i - 1, j + 1, false);
            turn(i, j - 1, false);
            turn(i, j, false);
            turn(i, j + 1, false);
            turn(i + 1, j - 1, false);
            turn(i + 1, j, false);
            turn(i + 1, j + 1, false);
        }

        private void turn(int i, int j, boolean on){
            int delta = 0;
            if (on){
                if (turnedOn[i][j]) return;

                turnedOn[i][j] = true;
                delta = 1;
            }else{
                if (i < 0 || i >= n || j < 0 || j >= n || !turnedOn[i][j]){
                    return;
                }

                turnedOn[i][j] = false;
                delta = -1;
            }

            grid[i][j] += delta;
            // 熄灭同一行
            for (int k = 0; k < n; k++) {
                if (k == j) continue;
                grid[i][k] += delta;
            }
            // 熄灭同一列
            for (int k = 0; k < n; k++) {
                if (k == i) continue;
                grid[k][j] += delta;
            }
            // 熄灭主对角线
            for (int k = 1; k < n && i + k < n && j + k < n; k++) {
                grid[i + k][j + k] += delta;
            }
            for (int k = 1; k < n && i - k >= 0 && j - k >= 0; k++) {
                grid[i - k][j - k] += delta;
            }
            // 熄灭副对角线
            for (int k = 0; k < n && i + k < n && j - k >= 0; k++) {
                grid[i + k][j - k] += delta;
            }
            for (int k = 0; k < n && i - k >= 0 && j + k < n; k++) {
                grid[i - k][j + k] += delta;
            }
        }
    }*/

    class Solution {

        int n;

        boolean[][] turnedOn;

        Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>(), left = new HashMap<>(), right = new HashMap<>();

        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            this.n = n;

            turnedOn = new boolean[n][n];
            // 初始化，点亮所有的灯
            for (int[] lamp : lamps) {
                int x = lamp[0], y = lamp[1];
                if (turnedOn[x][y]) continue;

                turnedOn[x][y] = true;
                row.put(x, row.getOrDefault(x, 0) + 1);
                col.put(y, col.getOrDefault(y, 0) + 1);
                left.put(x + y, left.getOrDefault(x + y, 0) + 1);
                right.put(x - y, right.getOrDefault(x - y, 0) + 1);
            }
            // 依次查询并关灯
            int[] rst = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int x = query[0], y = query[1];

                rst[i] = row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0
                        || left.getOrDefault(x + y, 0) > 0 || right.getOrDefault(x - y, 0) > 0 ? 1 : 0;
                turnOffRange(x, y);
            }
            return rst;
        }

        private void turnOffRange(int i, int j) {
            turnOff(i - 1, j - 1);
            turnOff(i - 1, j);
            turnOff(i - 1, j + 1);
            turnOff(i, j - 1);
            turnOff(i, j);
            turnOff(i, j + 1);
            turnOff(i + 1, j - 1);
            turnOff(i + 1, j);
            turnOff(i + 1, j + 1);
        }

        private void turnOff(int i, int j){
            if (i < 0 || i >= n || j < 0 || j >= n || !turnedOn[i][j]){
                return;
            }
            turnedOn[i][j] = false;
            if (row.get(i) > 0){
                row.put(i, row.get(i) - 1);
            }
            if (col.get(j) > 0){
                col.put(j, col.get(j) - 1);
            }
            if (left.get(i + j) > 0){
                left.put(i + j, left.get(i + j) - 1);
            }
            if (right.get(i - j) > 0){
                right.put(i - j, right.get(i - j) - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
