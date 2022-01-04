package editor.cn;
//两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。 
//
// 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。 
//
// 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。 
//
// 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。 
//
// 此外，猫无法移动到洞中（节点 0）。 
//
// 然后，游戏在出现以下三种情形之一时结束： 
//
// 
// 如果猫和老鼠出现在同一个节点，猫获胜。 
// 如果老鼠到达洞中，老鼠获胜。 
// 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。 
// 
//
// 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏： 
//
// 
// 如果老鼠获胜，则返回 1； 
// 如果猫获胜，则返回 2； 
// 如果平局，则返回 0 。 
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,3],[0],[3],[0,2]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= graph.length <= 50 
// 1 <= graph[i].length < graph.length 
// 0 <= graph[i][j] < graph.length 
// graph[i][j] != i 
// graph[i] 互不相同 
// 猫和老鼠在游戏中总是移动 
// 
// Related Topics 广度优先搜索 图 记忆化搜索 数学 动态规划 博弈 
// 👍 165 👎 0
	

//2022-01-04 14:18:37
public class P913CatAndMouse{
    public static void main(String[] args) {
        Solution solution = new P913CatAndMouse().new Solution();
        // TO TEST
        int[][] graph = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        System.out.println(solution.catMouseGame(graph));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][][] dp = new int[2 * 52 * 52][52][52];
        int[][] graph;
        int n;

        public int catMouseGame(int[][] graph) {
            this.graph = graph;
            n = graph.length;
            for (int k = 0; k < 2 * n * n; k++){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[k][i][j] = -1;
                    }
                }
            }
            return dfs(0, 1, 2);
        }

        //return 1: 老鼠获胜； return 2：猫获胜； return 0：平局
        private int dfs(int k, int mousePos, int catPos) {
            // 该状态已经试过了
            if (dp[k][mousePos][catPos] != -1) return dp[k][mousePos][catPos];

            if (mousePos == 0) {
                dp[k][mousePos][catPos] = 1;
                return 1;
            }
            if (catPos == mousePos){
                dp[k][mousePos][catPos] = 2;
                return 2;
            }
            if (k > 2 * n * n){
                dp[k][mousePos][catPos] = 0;
                return 0;
            }

            // 老鼠回合
            int rst = -1;
            if (k % 2 == 0){
                boolean win = false, draw = false;
                for (int next : graph[mousePos]){
                    int t = dfs(k + 1, next, catPos);
                    // 由于是走最优策略，因此如果下一步能胜利则当前状态就能胜利；平局亦然
                    if (t == 1){
                        win = true;
                        break;
                    }else if (t == 0){
                        draw = true;
                    }
                }

                if (win) rst = 1;
                else if (draw) rst = 0;
                else rst = 2;
            }
            // 猫回合
            else{
                boolean win = false, draw = false;
                for (int next : graph[catPos]){
                    if (next == 0) continue;

                    int t = dfs(k + 1, mousePos, next);
                    if (t == 2){
                        win = true;
                        break;
                    }else if (t == 0){
                        draw = true;
                    }
                }
                if (win) rst = 2;
                else if (draw) rst = 0;
                else rst = 1;
            }

            dp[k][mousePos][catPos] = rst;
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
