package editor.cn;
//给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。 
//
// 斐波那契数字定义为： 
//
// 
// F1 = 1 
// F2 = 1 
// Fn = Fn-1 + Fn-2 ， 其中 n > 2 。 
// 
//
// 数据保证对于给定的 k ，一定能找到可行解。 
//
// 
//
// 示例 1： 
//
// 输入：k = 7
//输出：2 
//解释：斐波那契数字为：1，1，2，3，5，8，13，……
//对于 k = 7 ，我们可以得到 2 + 5 = 7 。 
//
// 示例 2： 
//
// 输入：k = 10
//输出：2 
//解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
// 
//
// 示例 3： 
//
// 输入：k = 19
//输出：3 
//解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10^9 
// 
// Related Topics 贪心 
// 👍 100 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//2022-02-03 17:03:52
public class P1414FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK{
    public static void main(String[] args) {
        Solution solution = new P1414FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
        // TO TEST
        System.out.println(solution.findMinFibonacciNumbers(19));
        System.out.println(solution.findMinFibonacciNumbers(7));
        System.out.println(solution.findMinFibonacciNumbers(10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> nums = new HashSet<>();

        public int findMinFibonacciNumbers(int k) {
            nums.add(1);
            nums.add(2);
            nums.add(3);
            nums.add(5);
            nums.add(8);
            nums.add(13);

            return method(k);
        }

        private int method(int k){
            if (k == 0) return 0;
            if (nums.contains(k)) return 1;

            int a = 1, b = 1;
            while (a + b <= k){
                int c = a + b;
                a = b;
                b = c;
            }
            return method(k - b) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
