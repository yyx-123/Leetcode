package editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2430 👎 0


import java.util.ArrayList;
import java.util.List;

//2022-03-09 21:44:22
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> rst = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            generate(0, 0, n, sb ,rst);
            return rst;
        }

        private void generate(int n_left, int n_right, int n, StringBuilder sb, List<String> rst) {
            if (n_left == n && n_right == n){
                rst.add(sb.toString());
                return;
            }

            if (n_left == n){
                sb.append(')');
                n_right++;

                generate(n_left, n_right, n, sb, rst);

                n_right--;
                sb.deleteCharAt(sb.length() - 1);
            }else if (n_left == n_right){
                sb.append('(');
                n_left++;

                generate(n_left, n_right, n, sb, rst);
                n_left--;
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.append(')');
                n_right++;

                generate(n_left, n_right, n, sb, rst);

                n_right--;
                sb.deleteCharAt(sb.length() - 1);

                sb.append('(');
                n_left++;

                generate(n_left, n_right, n, sb, rst);
                n_left--;
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
