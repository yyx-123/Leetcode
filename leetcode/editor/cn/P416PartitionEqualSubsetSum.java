package editor.cn;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 1149 👎 0
	

//2022-02-22 15:16:09
public class P416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
        System.out.println(solution.canPartition(new int[]{1,5,11,5}));
        System.out.println(solution.canPartition(new int[]{1,2,3,4}));
        System.out.println(solution.canPartition(new int[]{1,2,3,10}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length, sum = 0;
            if (n == 1) return false;

            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) return false;

            int target = sum / 2;
            boolean[][] dp = new boolean[n][target + 1];
            if (nums[0] <= target) dp[0][nums[0]] = true;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= target; j++) {
                    if (nums[i] > j){
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[n - 1][target];
        }
    }*/

    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length, sum = 0;
            if (n == 1) return false;

            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) return false;

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            if (nums[0] <= target) dp[nums[0]] = true;

            for (int i = 1; i < n; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    if (dp[target]) return true;
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
