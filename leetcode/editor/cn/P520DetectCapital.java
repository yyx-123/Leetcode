package editor.cn;
//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
// Related Topics 字符串 
// 👍 169 👎 0
	

//2021-11-13 14:57:28
public class P520DetectCapital{
    public static void main(String[] args) {
        Solution solution = new P520DetectCapital().new Solution();
        // TO TEST
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("leetcode"));
        System.out.println(solution.detectCapitalUse("Google"));
        System.out.println(solution.detectCapitalUse("GoogLe"));
        System.out.println(solution.detectCapitalUse("GOogle"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            // 只有一个字符的时候肯定true
            if (word.length() == 1) return true;
            // 排除首字母为小写，第二个字符为大写的错误情况
            if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) return false;

            // 排除以上两个特例后，只要保证所有字符都与第二个字符同大小写即为true，反之为false
            char[] chars = word.toCharArray();
            Boolean secondUpper = Character.isUpperCase(chars[1]);
            for (int i = 1; i < chars.length; i++) {
               if (secondUpper){
                   if (Character.isLowerCase(chars[i])) return false;
               }else{
                   if (Character.isUpperCase(chars[i])) return false;
               }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
