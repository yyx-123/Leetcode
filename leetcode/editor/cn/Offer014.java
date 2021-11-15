package editor.cn;
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 16 👎 0


import java.util.Arrays;
import java.util.HashMap;

//2021-11-15 11:57:53
public class Offer014{
    public static void main(String[] args) {
        Solution solution = new Offer014().new Solution();
        // TO TEST
        System.out.println(solution.checkInclusion("abc","babc"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            int[] s1CharCnt = new int[26];
            for (char c : s1.toCharArray()){
                s1CharCnt[c - 'a']++;
            }

            int i = 0;
            while (i <= len2 - len1) {
                if (s1CharCnt[s2.charAt(i) - 'a'] == 0){
                    i++;
                    continue;
                }

                int[] tmpCharCnt = s1CharCnt.clone();
                for (int j = 0; j < len1; j++) {
                    char c = s2.charAt(i + j);

                    if (tmpCharCnt[c - 'a'] <= 0){
                        i++;
                        break;
                    }else {
                        tmpCharCnt[c - 'a']--;
                    }

                    if (Arrays.equals(tmpCharCnt, new int[26])) return true;
                }
            }
            return false;
        }
    }*/

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) return false;

            int[] diffCnt = new int[26];    // diffCnt中大于0的元素为子串还欠缺的，小于0的元素为子串多余的
            for (char c : s1.toCharArray()){
                diffCnt[c - 'a']++;
            }
            for (int i = 0; i < len1; i++) {
                diffCnt[s2.charAt(i) - 'a']--;
            }
            int diff = 0;
            for (int i = 0; i < 26; i++) {
                if (diffCnt[i] != 0) diff += Math.abs(diffCnt[i]);
            }

            for (int i = 0; i <= len2 - len1; i++) {
                if (diff == 0) return true;
                if (i == len2 - len1) return false;

                char x = s2.charAt(i), y = s2.charAt(i + len1); // x为即将被剔除的字符，y为即将加入的新字符
                if (x == y) continue;
                // 如果x字符本就是多余的，剔除它以后diff减少。不然（x并不多余甚至还欠缺）则剔除它以后diff增加
                if (diffCnt[x - 'a'] < 0) diff--;
                else diff++;
                // 在diffCnt中剔除x
                diffCnt[x - 'a']++;
                // 要新增的y字符同理可分析
                if (diffCnt[y - 'a'] > 0) diff--;
                else diff++;
                diffCnt[y - 'a']--;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
