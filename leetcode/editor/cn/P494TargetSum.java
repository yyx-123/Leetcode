package editor.cn;
//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 1067 👎 0
	

//2022-02-22 16:23:38
public class P494TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        System.out.println(solution.findTargetSumWays(new int[]{0,0,0,1}, 1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length, sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (target > sum || target < -sum) return 0;

            int[][] dp = new int[n][sum + 1];
            dp[0][nums[0]] = nums[0] == 0 ? 2 : 1;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 0; j <= sum; j++) {
                    if (j + num <= sum) dp[i][j] += dp[i - 1][j + num];
                    dp[i][j] += j - num >= 0 ? dp[i - 1][j - num] : dp[i - 1][num - j];
                }
            }
            return target >= 0 ? dp[n - 1][target] : dp[n - 1][-target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
