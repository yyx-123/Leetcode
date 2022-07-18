package editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 7043 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//2022-03-07 13:19:35
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {

            if (s.equals("")) return 0;

            int i = 0;
            int max = 1;
            Set<Character> set = new HashSet<>();

            while (i < s.length() - 1){
                set = new HashSet<>();
                set.add(s.charAt(i));

                int j = i + 1;
                while (j < s.length() && !set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                }

                max = Math.max(max, j - i);
                i++;
            }

            return max;
        }
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")) return 0;

            int max = 1;
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            while (start < s.length()){
                map = new HashMap<>();
                map.put(s.charAt(start), start);


                int end = start + 1;
                while (end < s.length() && !map.containsKey(s.charAt(end))){
                    map.put(s.charAt(end), end);
                    end++;
                    max = Math.max(max, map.size());
                }

                if (end == s.length()) break;
                start = map.get(s.charAt(end)) + 1;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
