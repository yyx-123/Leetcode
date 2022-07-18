package editor.cn;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1495 👎 0


import java.util.ArrayList;
import java.util.List;

//2022-03-02 10:39:24
public class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST

        System.out.println(solution.subsets(new int[]{0}));
        System.out.println(solution.subsets(new int[]{1,2,3}));

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> indices = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            int len = 0, n = nums.length;
            backtrack(len, n, path, indices);


            List<List<Integer>> rst = new ArrayList<>();
            for (List<Integer> index : indices) {
                List<Integer> subset = new ArrayList<>();
                for (Integer integer : index) {
                    subset.add(nums[integer]);
                }
                rst.add(subset);
            }
            return rst;
        }

        private void backtrack(int len, int n, List<Integer> path, List<List<Integer>> indices) {
            if (len > n) return;

            indices.add(new ArrayList<>(path));

            int cur = path.size() == 0 ? -1 : path.get(path.size() - 1);
            for (int i = cur + 1; i < n; i++) {
                path.add(i);
                len++;

                backtrack(len, n, path, indices);

                len--;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
