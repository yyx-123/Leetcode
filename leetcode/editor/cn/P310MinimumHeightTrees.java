package editor.cn;
//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 493 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//2022-04-06 09:32:20
public class P310MinimumHeightTrees{
    public static void main(String[] args) {
        Solution solution = new P310MinimumHeightTrees().new Solution();
        // TO TEST
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        System.out.println(solution.findMinHeightTrees(4, edges));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 暴力解法：每一个节点依次计算他们的高度（用BFS），然后返回高度最低的集合
     */
    /*class Solution {

        int n;

        List<Integer>[] neighbors;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {

            if (n == 1){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                return list;
            }

            buildGraph(n, edges);

            int[] heights = new int[n];
            int minHeight = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int height = countHeight(i);
                minHeight = Math.min(minHeight, height);
                heights[i] = height;
            }

            List<Integer> rst = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (heights[i] == minHeight) rst.add(i);
            }

            return rst;
        }

        private int countHeight(int root) {
            boolean[] visited = new boolean[n];
            visited[root] = true;
            int height = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()){
                height++;

                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int child = q.poll();

                    visited[child] = true;
                    for (Integer neighbor : neighbors[child]) {
                        if (!visited[neighbor]) q.add(neighbor);
                    }
                }
            }
            return height;
        }

        private void buildGraph(int n, int[][] edges) {
            this.n = n;
            neighbors = new List[n];

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];

                if (neighbors[u] == null){
                    neighbors[u] = new LinkedList<>();
                }
                neighbors[u].add(v);
                if (neighbors[v] == null){
                    neighbors[v] = new LinkedList<>();
                }
                neighbors[v].add(u);
            }
        }
    }*/

    /**
     * 改进解法：从叶子结点（度为1）开始，剪一圈叶子，向根靠近
     */
    class Solution {

        int n;

        List<Integer>[] neighbors;

        int[] degrees;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            ArrayList<Integer> list = new ArrayList<>();

            if (n == 1){
                list.add(0);
                return list;
            }

            buildGraph(n, edges);

            // 创建一个叶子结点集合，将初始状态下的叶子结点全部入队
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 1) q.offer(i);
            }

            while (!q.isEmpty()){
                // 每一次while循环到这里，就说明有新的一波叶子结点了。
                // 这些叶子节点可能就是答案的一部分，因此在之后poll的时候，poll出来的元素都会加到list里
                // 一旦while退出了，那么list里放的就是最后一次poll出来的叶子们，也就是题目中最靠近中心的根节点
                list = new ArrayList<>();

                // 常规的BFS流程，只是多加了一层for循环，将新的叶子结点入队
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = q.poll();
                    list.add(poll);

                    // 由于叶子poll已经被找到并删除了，因此它的邻居的度都需要减一
                    // 如果邻居的度被减到1了，说明该邻居成为了新的叶子结点
                    for (Integer neighbor : neighbors[poll]) {
                        degrees[neighbor]--;
                        if (degrees[neighbor] == 1) q.offer(neighbor);
                    }
                }
            }

            return list;
        }

        private void buildGraph(int n, int[][] edges) {
            this.n = n;
            neighbors = new List[n];
            degrees = new int[n];

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];

                if (neighbors[u] == null){
                    neighbors[u] = new LinkedList<>();
                }
                neighbors[u].add(v);
                degrees[u]++;

                if (neighbors[v] == null){
                    neighbors[v] = new LinkedList<>();
                }
                neighbors[v].add(u);
                degrees[v]++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
