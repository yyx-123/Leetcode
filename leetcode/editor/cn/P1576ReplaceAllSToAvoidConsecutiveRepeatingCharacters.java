package editor.cn;
//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。 
//
// 注意：你 不能 修改非 '?' 字符。 
//
// 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。 
//
// 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。 
//
// 
//
// 示例 1： 
//
// 输入：s = "?zs"
//输出："azs"
//解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两
//个 'z' 。 
//
// 示例 2： 
//
// 输入：s = "ubv?w"
//输出："ubvaw"
//解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
// 
//
// 示例 3： 
//
// 输入：s = "j?qg??b"
//输出："jaqgacb"
// 
//
// 示例 4： 
//
// 输入：s = "??yw?ipkj?"
//输出："acywaipkja"
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 100 
// 
// 
// s 仅包含小写英文字母和 '?' 字符 
// 
// 
// Related Topics 字符串 
// 👍 88 👎 0
	

//2022-01-05 20:16:19
public class P1576ReplaceAllSToAvoidConsecutiveRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P1576ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
        // TO TEST
        String s = "??yw?ipkj?";
        System.out.println(solution.modifyString(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append('.');
            sb.append(s);
            sb.append('.');
            char[] chars = sb.toString().toCharArray();
            int n = s.length();

            int i = 1;
            while (i <= n){
                if (chars[i] != '?') {
                    i++;
                    continue;
                }

                char head = chars[i - 1];
                for (int j = 0; j < 26; j++) {
                    char c = (char)('a' + j);
                    if (c != head && c != chars[i + 1]){
                        chars[i] = c;
                        i++;
                        break;
                    }
                }
            }
            sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                sb.append(chars[j]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
