package editor.cn;
//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 104 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 
// 👍 204 👎 0


import java.util.HashSet;

//2021-12-23 11:10:51
public class P1044LongestDuplicateSubstring{
    public static void main(String[] args) {
        Solution solution = new P1044LongestDuplicateSubstring().new Solution();
        // TO TEST
        String s = "aaa";
        System.out.println(solution.longestDupSubstring(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDupSubstring(String s) {
            int left = 0, right = s.length() - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (check(s, mid)) left = mid + 1;
                else right = mid - 1;
            }

            if (right == 0) return "";
            else return find(s, right);
        }

        private String find(String s, int m) {
            int n = s.length();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i <= n - m; i++) {
                String subString = s.substring(i, i + m);

                if (set.contains(subString)) return subString;
                else set.add(subString);
            }
            return null;
        }

        private boolean check(String s, int m) {
            int n = s.length();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i <= n - m; i++) {
                String subString = s.substring(i, i + m);

                if (set.contains(subString)) return true;
                else set.add(subString);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
