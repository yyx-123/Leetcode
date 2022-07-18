package editor.cn;
//给定一个数字字符串 num，比如 "123456579"，我们可以将它分成「斐波那契式」的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式 序列是一个非负整数列表 f，且满足： 
//
// 
// 0 <= f[i] < 231 ，（也就是说，每个整数都符合 32 位 有符号整数类型） 
// f.length >= 3 
// 对于所有的0 <= i < f.length - 2，都有 f[i] + f[i + 1] = f[i + 2] 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 num 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "1101111"
//输出：[11,0,11,11]
//解释：输出[110,1,111]也可以。 
//
// 示例 2： 
//
// 
//输入: num = "112358130"
//输出: []
//解释: 无法拆分。
// 
//
// 示例 3： 
//
// 
//输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 200 
// num 中只含有数字 
// 
// Related Topics 字符串 回溯 
// 👍 253 👎 0


import java.util.LinkedList;
import java.util.List;

//2022-03-22 11:38:14
public class P842SplitArrayIntoFibonacciSequence{
    public static void main(String[] args) {
        Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer> rst;
        
        public List<Integer> splitIntoFibonacci(String num) {

            int idx = 0;
            List<Integer> path = new LinkedList<>();

            backtrack(num, idx, path);

            return rst;
        }

        private void backtrack(String num, int idx, List<Integer> path) {
            if (idx == num.length()){
                rst = new LinkedList<>(path);
                return;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
