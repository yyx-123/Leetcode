package editor.cn;
//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 
// 👍 115 👎 0
	

//2022-02-23 09:13:03
public class P917ReverseOnlyLetters{
    public static void main(String[] args) {
        Solution solution = new P917ReverseOnlyLetters().new Solution();
        // TO TEST
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int len = s.length();
            int i = 0, j = len - 1;
            char[] chars = s.toCharArray();

            while (i < j){
                while (i < j && !Character.isLetter(chars[i])) i++;
                while (i < j && !Character.isLetter(chars[j])) j--;

                if (i < j){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
                i++;
                j--;
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
