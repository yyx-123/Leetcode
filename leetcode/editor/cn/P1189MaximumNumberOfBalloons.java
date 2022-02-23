package editor.cn;
//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 76 👎 0
	

//2022-02-13 11:17:34
public class P1189MaximumNumberOfBalloons{
    public static void main(String[] args) {
        Solution solution = new P1189MaximumNumberOfBalloons().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] charCnt = new int[26];

            for (char c : text.toCharArray()){
                charCnt[c - 'a']++;
            }

            int cnt = 0;
            while (charCnt[0] >= 1 && charCnt[1] >= 1 && charCnt['l' - 'a'] >= 2 && charCnt['n' - 'a'] >= 1 && charCnt['o' - 'a'] >= 2){
                cnt++;

                charCnt[0]--;
                charCnt[1]--;
                charCnt['n' - 'a']--;
                charCnt['l' - 'a'] -= 2;
                charCnt['o' - 'a'] -= 2;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
