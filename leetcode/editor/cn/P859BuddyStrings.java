package editor.cn;
//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 104 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 212 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//2021-11-23 15:11:39
public class P859BuddyStrings{
    public static void main(String[] args) {
        Solution solution = new P859BuddyStrings().new Solution();
        // TO TEST
        System.out.println(solution.buddyStrings("aa", "aa"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean hasSameChars(int[] charCnt){
            for (int i = 0; i < 26; i++) {
                if (charCnt[i] > 1) return true;
            }
            return false;
        }

        public boolean buddyStrings(String s, String goal) {
            // 如果字符串长度都不相等，则一定做不到
            if (s.length() != goal.length()) return false;

            // 记录两个字符串的字符频、以及对应位置不相等的字符数
            int diff = 0;
            int[] charCnt_s = new int[26];
            int[] charCnt_goal = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c_s = s.charAt(i), c_goal = goal.charAt(i);
                charCnt_s[c_s - 'a']++;
                charCnt_goal[c_goal - 'a']++;
                if (c_s != c_goal) diff++;
            }
            // 如果字符串的字符频不相等，则一定做不到
            if (!Arrays.equals(charCnt_s, charCnt_goal)) return false;

            // 如果diff为0，说明两个字符串完全一样。如果字符串中有重复出现的字符则可以(比如两个aa, 两个abab)，但是如果字符串没有重复的字符（比如两个ab）则不可以
            if (diff == 0) return hasSameChars(charCnt_s);
            // 如果恰有两个字符不同，则可以通过交换得到，其余则均不行
            if (diff != 2) return false;
            else return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
