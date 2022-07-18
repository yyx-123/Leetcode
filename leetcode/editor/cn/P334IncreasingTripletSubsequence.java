package editor.cn;
//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true
// ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
// Related Topics 贪心 数组 
// 👍 437 👎 0
	

//2022-01-12 10:59:36
public class P334IncreasingTripletSubsequence{
    public static void main(String[] args) {
        Solution solution = new P334IncreasingTripletSubsequence().new Solution();
        // TO TEST
        int[] nums = {2,1,5,0,4,6};
        System.out.println(solution.increasingTriplet(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        public boolean increasingTriplet(int[] nums) {
            this.nums = nums;
            // return increasing(3, 0, Integer.MIN_VALUE);
            if (nums.length < 3) return false;

            int small = Integer.MIN_VALUE, mid = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < small){
                    small = nums[i];
                }else if (nums[i] < mid){
                    mid = nums[i];
                }else if (nums[i] > mid){
                    return true;
                }
            }
            return false;
        }

        // 递归思路。increasing函数的作用是返回以nums[start:]的子序列中是否有超过threshold的长度为remain元组。但是TLE
        private boolean increasing(int remain, int start, int threshold) {
            if (remain == 1){
                for (int i = start; i < nums.length; i++) {
                    if (nums[i] > threshold) return true;
                }
            }else{
                for (int i = start; i < nums.length - (remain - 1); i++) {
                    if (nums[i] > threshold && increasing(remain - 1, i + 1, nums[i])) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
