package editor.cn;
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-subs
//tring/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 11 👎 0
	

//2021-11-15 16:34:15
public class Offer017minWindow{
    public static void main(String[] args) {
        Solution solution = new Offer017minWindow().new Solution();
        // TO TEST
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] charCnt;

        private boolean check(int[] actualCnt){
            for (int i = 0; i < 52; i++) {
                if (actualCnt[i] < charCnt[i]) return false;
            }
            return true;
        }

        public String minWindow(String s, String t) {
            charCnt = new int[52];
            for (char c : t.toCharArray()) {
                if (Character.isLowerCase(c))  charCnt[c - 'a']++;
                else charCnt[c - 'A' + 26]++;
            }

            int[] actualCnt = new int[52];
            int i = 0, j = -1;
            int minLen = Integer.MAX_VALUE;
            int minSubstringStartIdx = -1;
            while (j < s.length()){
                while (j < s.length() && !check(actualCnt)){
                    j++;
                    if (j < s.length()){
                        if (Character.isLowerCase(s.charAt(j))) actualCnt[s.charAt(j) - 'a']++;
                        else actualCnt[s.charAt(j) - 'A' + 26]++;

                    }
                }

                while (i <= j && check(actualCnt)){
                    if (j - i + 1 < minLen){
                        minLen = j - i + 1;
                        minSubstringStartIdx = i;
                    }
                    if (Character.isLowerCase(s.charAt(i))) actualCnt[s.charAt(i) - 'a']--;
                    else actualCnt[s.charAt(i) - 'A' + 26]--;
                    i++;
                }
            }
            return minSubstringStartIdx == -1 ? "" : s.substring(minSubstringStartIdx, minSubstringStartIdx + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
