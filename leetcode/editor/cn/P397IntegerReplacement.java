package editor.cn;
//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 贪心 位运算 记忆化搜索 动态规划 
// 👍 159 👎 0


import java.util.HashMap;

//2021-11-19 12:24:53
public class P397IntegerReplacement{
    public static void main(String[] args) {
        Solution solution = new P397IntegerReplacement().new Solution();
        // TO TEST
        System.out.println(solution.integerReplacement(8));
        System.out.println(solution.integerReplacement(7));
        System.out.println(solution.integerReplacement(4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 最基本的递归，但是会溢出
     */
    /*class Solution {
        public int integerReplacement(int n) {
            if (n == 1) return 0;

            if ((n & 1) == 1) {
                return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            }else{
                return integerReplacement(n / 2) + 1;
            }
        }
    }*/

    /**
     * dfs函数的递归思路与之前相同，只是在递归的过程中如果得到了结果则把结果记录保存一下，防止重复计算
     * 有一个问题在于同样的代码，当n为long时就不会Stack Overflow，如果n为int就会Stack Overflow，不知道为啥
     */
    /*class Solution {
        private HashMap<Long, Integer> map = new HashMap<>();

        private int dfs(long n){
            if (map.containsKey(n)) return map.get(n);

            int ans;
            if (n % 2 == 0) {
                ans = dfs(n / 2) + 1;
            }else{
                ans = Math.min(dfs(n + 1), dfs(n - 1)) + 1;
            }
            map.put(n, ans);

            return ans;
        }

        public int integerReplacement(int n) {
            map.put(1L, 0);
            return dfs((long)n);
        }
    }*/

    class Solution {
        private HashMap<Long, Integer> map = new HashMap<>();

        private int dfs(long n){
            if (map.containsKey(n)) return map.get(n);

            int ans;
            if (n % 2 == 0) {
                ans = dfs(n / 2) + 1;
            }else{
                if ((n & 2) == 2) ans = dfs(n + 1) + 1;
                else ans = dfs(n - 1) + 1;
            }
            map.put(n, ans);

            return ans;
        }

        public int integerReplacement(int n) {
            map.put(1L, 0);
            map.put(3L, 2);
            return dfs(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
