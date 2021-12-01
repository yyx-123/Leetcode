package editor.cn;
//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。 
// 
// Related Topics 数学 二分查找 
// 👍 253 👎 0


//2021-11-30 18:38:35
public class P400NthDigit{
    public static void main(String[] args) {
        Solution solution = new P400NthDigit().new Solution();
        // TO TEST
        for (int i = 1; i < 100; i++) {
            System.out.println(solution.findNthDigit(i));
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Long pow(Long x){
            Long rst = 1L;
            for (int i = 0; i < x; i++) {
                rst *= 10;
            }
            return rst;
        }

        public int findNthDigit(int n) {
            Long x = 1L;
            while (n > 0){
                n -= 9 * Math.pow(10, x - 1) * x;
                x++;
            }
            x--;
            n += 9 * Math.pow(10, x - 1) * x;

            Long num = pow(x - 1);
            Long cnt = n / x;
            for (int i = 0; i < cnt - 1; i++) {
                num++;
            }
            n -= cnt * x;

            if (n == 0){
                return (int) (num % 10);
            }else {
                String s = String.valueOf(++num);
                return Integer.parseInt(s.substring(n - 1, n));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
