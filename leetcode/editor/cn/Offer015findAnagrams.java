package editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-str
//ing/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 7 👎 0


import java.util.LinkedList;
import java.util.List;

//2021-11-15 15:19:07
public class Offer015findAnagrams {
    public static void main(String[] args) {
        Solution solution = new Offer015findAnagrams().new Solution();
        // TO TEST
        //String s = "cbaebabacd", p = "abc";
        String s = "abab", p = "ab";
        System.out.println(solution.findAnagrams(s, p));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            LinkedList<Integer> list = new LinkedList<>();
            int len1 = s.length(), len2 = p.length();

            if (len1 < len2) return list;

            int[] diffCnt = new int[26];        // diffCnt中大于0的元素为子串中缺乏的，小于0的元素为子串中多余的
            int diff = 0;
            for (int i = 0; i < len2; i++) {
                diffCnt[p.charAt(i) - 'a']++;
                diffCnt[s.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (diffCnt[i] != 0) diff += Math.abs(diffCnt[i]);
            }

            for (int i = 0; i <= len1 - len2; i++) {
                if (diff == 0) list.add(i);
                if (i == len1 - len2) break;

                char x = s.charAt(i), y = s.charAt(i + len2);  // x为即将删除的字符，y为即将加入的字符
                if (diffCnt[x - 'a'] < 0) diff--;
                else diff++;
                diffCnt[x - 'a']++;
                if (diffCnt[y - 'a'] > 0) diff--;
                else diff++;
                diffCnt[y - 'a']--;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
