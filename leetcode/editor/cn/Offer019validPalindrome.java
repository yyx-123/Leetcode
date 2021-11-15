package editor.cn;
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 105 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 
// 👍 12 👎 0
	

//2021-11-15 19:54:51
public class Offer019validPalindrome{
    public static void main(String[] args) {
        Solution solution = new Offer019validPalindrome().new Solution();
        // TO TEST
        String s = "ebcbbececabbacecbbcbe";
        System.out.println(solution.validPalindrome(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 检查一个字符串是否回文，与题意的区别在于没有可以删除一个字符的条件
        public boolean validPalindromeNoDelete(String s){
            int i = 0 , j = s. length() - 1;
            while (i < j){
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        // 可以删除一个字符的回文字符串检测看书
        public boolean validPalindrome(String s) {
            int deletableCnts = 1;

            int i = 0, j = s.length() - 1;
            while (i < j){
                while (i < j && s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }
                if (i == j || i == j + 1) return true;

                // 走到这一步说明遇到了不满足回文字符串的地方，如果此时有删除字符的余量deletableCnts则有机会“复活”继续检查，不然的话就没机会了返回false
                if (deletableCnts != 0){
                    // 在这种情况下任意删除i或者j即可做到，返回true
                    if (i == j - 1) return true;
                    // 这种情况下不知道该删除i的字符还是该删除j的字符，那么就两种情况各自试一试，只要有成功的即可
                    if (s.charAt(j - 1) == s.charAt(i) && s.charAt(i + 1) == s.charAt(j)) return validPalindromeNoDelete(s.substring(i, j)) || validPalindromeNoDelete(s.substring(i+1, j+1));
                    // 这2种情况下该删除i还是j是显而易见的，进行删除并将余量减一
                    if (s.charAt(j - 1) == s.charAt(i)) j--;
                    else if (s.charAt(i + 1) == s.charAt(j)) i++;
                    else return false;  // 如果不是以上的这几种情况，那么即使有删除字符的余量也无济于事无力回天了，返回false
                    deletableCnts--;
                }else return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
