package editor.cn;
//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。 
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 
// 👍 199 👎 0
	

//2022-04-07 10:34:45
public class P796RotateString{
    public static void main(String[] args) {
        Solution solution = new P796RotateString().new Solution();
        // TO TEST
        System.out.println(solution.rotateString("abcde", "cdeab"));
        System.out.println(solution.rotateString("abcde", "abcde"));
        System.out.println(solution.rotateString("abcde", "abced"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;

            int len = s.length();

            // s划分成[x, y]两部分子串，则goal应该是[y, x]两部分
            for (int i = 0; i < len; i++) {
                 if (s.substring(0, i).equals(goal.substring(len - i, len)) &&
                 s.substring(i, len).equals(goal.substring(0, len - i))) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
