package editor.cn;
//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数组 哈希表 数学 前缀和 
// 👍 407 👎 0
	

//2022-02-28 15:10:25
public class P523ContinuousSubarraySum{
    public static void main(String[] args) {
        Solution solution = new P523ContinuousSubarraySum().new Solution();
        // TO TEST
        System.out.println(solution.checkSubarraySum(new int[]{1,2,3}, 6));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;

            if (n == 1) return false;
            else if (n == 2) return (nums[0] + nums[1]) % k == 0;

            int[] preSum = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                preSum[i] = (preSum[i - 1] + nums[i - 1]) % k;
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 2; j < n + 1; j++) {
                    int sum = preSum[j] - preSum[i];
                    if (sum % k == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
