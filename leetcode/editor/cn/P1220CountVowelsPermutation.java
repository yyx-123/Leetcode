package editor.cn;
//给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串： 
//
// 
// 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'） 
// 每个元音 'a' 后面都只能跟着 'e' 
// 每个元音 'e' 后面只能跟着 'a' 或者是 'i' 
// 每个元音 'i' 后面 不能 再跟着另一个 'i' 
// 每个元音 'o' 后面只能跟着 'i' 或者是 'u' 
// 每个元音 'u' 后面只能跟着 'a' 
// 
//
// 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：5
//解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：10
//解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
// 
//
// 示例 3： 
//
// 输入：n = 5
//输出：68 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10^4 
// 
// Related Topics 动态规划 
// 👍 101 👎 0
	

//2022-01-17 15:32:24
public class P1220CountVowelsPermutation{
    public static void main(String[] args) {
        Solution solution = new P1220CountVowelsPermutation().new Solution();
        // TO TEST
        System.out.println(solution.countVowelPermutation(1));
        System.out.println(solution.countVowelPermutation(2));
        System.out.println(solution.countVowelPermutation(5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelPermutation(int n) {
            // dp[i][j]指长度为i，以j结尾的组合个数。a,e,i,o,u对应j=0,1,2,3,4
            /**
             * a -> e
             * e -> a, i
             * i -> a, e, o, u
             * o -> i, u
             * u -> a
             */
            long[][] dp = new long[n + 1][5];
            int p = 1000000007;

            for (int i = 0; i < 5; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4];
                dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
                dp[i][2] = dp[i - 1][1] + dp[i - 1][3];
                dp[i][3] = dp[i - 1][2];
                dp[i][4] = dp[i - 1][2] + dp[i - 1][3];

                for (int j = 0; j < 5; j++) dp[i][j] %= p;
            }

            int rst = 0;
            for (int i = 0; i < 5; i++) {
                rst = (rst % p + (int)(dp[n][i] % p) ) % p;
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
