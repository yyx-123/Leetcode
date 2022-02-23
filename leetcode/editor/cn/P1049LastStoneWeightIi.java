package editor.cn;
//有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。 
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 
//
// 示例 2： 
//
// 
//输入：stones = [31,26,33,21,40]
//输出：5
// 
//
// 示例 3： 
//
// 
//输入：stones = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 391 👎 0
	

//2022-02-22 16:13:16
public class P1049LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new P1049LastStoneWeightIi().new Solution();
        // TO TEST
        System.out.println(solution.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(solution.lastStoneWeightII(new int[]{1, 99}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length, sum = 0;
            if (n == 1) return stones[0];
            for (int stone : stones) {
                sum += stone;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            for (int i = 0; i < n; i++) {
                for (int j = target; j >= stones[i]; j--) {
                    if (j == stones[i]) dp[j] = true;
                    dp[j] = dp[j] || dp[j - stones[i]];
                }
            }

            for (int i = target; i >= 0; i--) {
                if (dp[i]){
                    return sum - 2 * i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
