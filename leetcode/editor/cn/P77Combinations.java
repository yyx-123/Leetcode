package editor.cn;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 862 👎 0


import java.util.ArrayList;
import java.util.List;

//2022-02-17 16:41:03
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        System.out.println(solution.combine(4, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int k;

        int n;

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            this.n = n;

            List<List<Integer>> rst = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] hasUsed = new boolean[n + 1];

            backtrack(hasUsed, path, rst);
            return rst;
        }

        private void backtrack(boolean[] hasUsed, List<Integer> path, List<List<Integer>> rst) {
            if (path.size() == k){
                rst.add(new ArrayList<>(path));
                return;
            }

            int i = path.isEmpty() ? 1 : path.get(path.size() - 1) + 1;
            for (; i <= n; i++) {
                if (!hasUsed[i]){
                    path.add(i);
                    hasUsed[i] = true;

                    backtrack(hasUsed, path, rst);

                    path.remove(path.size() - 1);
                    hasUsed[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
