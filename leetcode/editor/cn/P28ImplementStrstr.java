package editor.cn;
//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1179 👎 0
	

//2021-12-24 20:51:58
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
        String s = "abcabdaabcabcd";
        String p = "abcabc";

        System.out.println(solution.KMP(s, p));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equals(""))  return 0;
            return KMP(haystack, needle);
        }

        private int KMP(String s, String p) {
            int[] next = getNext(p);
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()){
                while (i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)){
                    i++;
                    j++;
                }
                if (j == p.length()) return i - p.length();
                else if (j == 0) i++;
                else j = next[j - 1];
            }
            return -1;
        }

        private int[] getNext(String p){
            int[] next = new int[p.length()];
            char[] pChars = p.toCharArray();
            int now = 0, i = 1;
            while (i < p.length()) {
                if (pChars[i] == pChars[now]) {
                    next[i] = now + 1;
                    now++;
                    i++;
                }else{
                    if (now > 0){
                        now = next[now - 1];
                    }else {
                        next[i] = 0;
                        i++;
                    }
                }
            }

            return next;
        }
    }*/

    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equals(""))  return 0;
            return KMP(haystack, needle);
        }

        private int KMP(String s, String p) {
            int[] next = getNext(p);
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()){
                while (i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)){
                    i++;
                    j++;
                }

                if (j == p.length()) return i - p.length();
                if (j == 0){
                    i++;
                }else{
                    j = next[j - 1];
                }
            }
            return -1;
        }

        private int[] getNext(String p) {
            int[] next = new int[p.length()];

            int i = 1, now = 0;
            while (i < p.length()){
                if (p.charAt(i) == p.charAt(now)){
                    next[i] = ++now;
                    i++;
                }else{
                    if (now > 0){
                        now = next[now - 1];
                    }else{
                        next[i] = 0;
                        i++;
                    }
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
