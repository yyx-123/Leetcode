package editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
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
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 702 👎 0


import java.util.*;

//2021-11-28 19:36:06
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution2 solution = new P438FindAllAnagramsInAString().new Solution2();
        // TO TEST
        String s = "cbaebabacd", p = "abc";
        System.out.println(solution.findAnagrams(s, p));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> rst = new LinkedList<>();

            if (s.length() < p.length()) return rst;

            int len = p.length();
            int[] pCharCnt = new int[26];
            for (int i = 0; i < len; i++) {
                pCharCnt[p.charAt(i) - 'a']++;
            }

            for (int i = 0; i <= s.length() - len; i++) {
                String subString = s.substring(i, i + len);
                int[] subStringCharCnt = new int[26];
                for (int j = 0; j < len; j++) {
                    subStringCharCnt[subString.charAt(j) - 'a']++;
                }
                if (Arrays.equals(pCharCnt, subStringCharCnt)) rst.add(i);
            }
            return rst;
        }
    }

    class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> rst = new LinkedList<>();

            if (s.length() < p.length()) return rst;

            int len = p.length();
            int[] pCharCnt = new int[26];
            for (int i = 0; i < len; i++) {
                pCharCnt[p.charAt(i) - 'a']++;
            }

            int j = 0;
            int[] subStringCharCnt = new int[26];
            for (; j < len; j++){
                subStringCharCnt[s.charAt(j) - 'a']++;
            }
            for (int i = 0; i <= s.length() - len; i++) {
                if (Arrays.equals(subStringCharCnt, pCharCnt)) rst.add(i);

                if (j == s.length()) break;
                subStringCharCnt[s.charAt(j) - 'a']++;
                subStringCharCnt[s.charAt(i) - 'a']--;
                j++;
            }
            return rst;
        }
    }
    /*class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> rst = new LinkedList<>();

            if (s.length() < p.length()) return rst;

            int len = p.length();
            // diffChar中大于0的说明p有的，s缺少的；小于0的说明p没有的s多余的
            int[] diffChar = new int[26];
            for (int i = 0; i < len; i++) {
                diffChar[p.charAt(i) - 'a']++;
            }
            int j = 0;
            for (; j < len; j++) {
                diffChar[s.charAt(j) - 'a']--;
            }
            int diff = 0;
            for (int k = 0; k < 26; k++) {
                diff += Math.abs(diffChar[k]);
            }

            int i = 0;
            for (; i <= s.length() - len; i++) {
                if (diff == 0) rst.add(i);
                if (j == s.length()) break;

                if (s.charAt(i) == s.charAt(j)){
                    j++;
                    continue;
                }

                if (diffChar[s.charAt(i) - 'a'] < 0) diff--;
                else diff++;
                diffChar[s.charAt(i) - 'a']++;
                if (diffChar[s.charAt(j) - 'a'] > 0) diff--;
                else diff++;
                diffChar[s.charAt(j) - 'a']--;
                j++;
            }
            return rst;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}
