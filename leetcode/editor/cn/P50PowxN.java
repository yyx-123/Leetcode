package editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 804 👎 0
	

//2021-12-05 14:42:11
public class P50PowxN{
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        // TO TEST
        System.out.println(solution.myPow(2,10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                if (n == Integer.MIN_VALUE){
                    return (1 / x) * myPow(x, n + 1);
                }
                return 1 / myPow(x, -n);
            }
            else if (n == 0) return 1;
            else{
                if (n == 1) return x;
                // 以上代码均是对n <= 1特殊情况的转化，以下是对n为正整数时的快速幂解法
                double rst = 1;
                while (n > 0){
                    if ((n & 1) == 1) rst *= x;
                    x *= x;
                    n >>= 1;
                }
                return rst;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
