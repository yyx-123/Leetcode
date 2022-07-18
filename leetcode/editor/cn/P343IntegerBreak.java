package editor.cn;
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 
// 👍 712 👎 0
	

//2022-02-22 13:38:29
public class P343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        // TO TEST
        System.out.println(solution.integerBreak(8));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            if (n == 2) return 1;
            else if (n == 3) return 2;
            else if (n == 4) return 4;

            int[] dp = new int[n + 1];
            dp[2] = 1;
            dp[3] = 2;
            for (int i = 4; i <= n; i++) {
                int max = -1;
                for (int j = 2; j < i - 2; j++) {
                    max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = max;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
