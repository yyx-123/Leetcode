package editor.cn;
//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。 
//
// 示例 2： 
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
// 
//
// 示例 3： 
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。 
//
// 示例 4： 
//
// 输入：n = 1
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 字符串 数论 
// 👍 46 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//2022-02-10 10:47:31
public class P1447SimplifiedFractions{
    public static void main(String[] args) {
        Solution solution = new P1447SimplifiedFractions().new Solution();
        // TO TEST
        List<String> result = solution.simplifiedFractions(8);
        result.forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> simplifiedFractions(int n) {
            if (n == 1) return new ArrayList<String>();
            if (n == 2){
                List<String> list = new ArrayList<>();
                list.add("1/2");
                return list;
            }

            List<String> result = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (gcd(i, n) == 1){
                    result.add(String.valueOf(i) + "/" + String.valueOf(n));
                }
            }
            result.addAll(simplifiedFractions(n - 1));
            return result;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
