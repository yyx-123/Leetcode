package editor.cn;

import java.util.Arrays;

public class P279PerfectSquares{
    public static void main(String[] args){
        Solution solution = new P279PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = n;
            for (int j = 0; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}