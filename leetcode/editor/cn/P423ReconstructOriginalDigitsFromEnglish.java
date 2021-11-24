package editor.cn;
//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 153 👎 0
	

//2021-11-24 20:59:54
public class P423ReconstructOriginalDigitsFromEnglish{
    public static void main(String[] args) {
        Solution solution = new P423ReconstructOriginalDigitsFromEnglish().new Solution();
        // TO TEST
        String s = "fviefuro";
        System.out.println(solution.originalDigits(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String originalDigits(String s) {
            int[] charCnt = new int[26];
            int[] digitCnt = new int[10];
            for (char c : s.toCharArray()) charCnt[c - 'a']++;

            // 第一轮，根据z, w, u, x, g判断出0 2 4 6 8
            int cnt;
            if ((cnt = charCnt['z' - 'a']) > 0){
                digitCnt[0] += cnt;
                charCnt['z' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
                charCnt['r' - 'a'] -= cnt;
                charCnt['o' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['w' - 'a']) > 0){
                digitCnt[2] += cnt;
                charCnt['t' - 'a'] -= cnt;
                charCnt['w' - 'a'] -= cnt;
                charCnt['o' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['u' - 'a']) > 0){
                digitCnt[4] += cnt;
                charCnt['f' - 'a'] -= cnt;
                charCnt['o' - 'a'] -= cnt;
                charCnt['u' - 'a'] -= cnt;
                charCnt['r' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['x' - 'a']) > 0){
                digitCnt[6] += cnt;
                charCnt['s' - 'a'] -= cnt;
                charCnt['i' - 'a'] -= cnt;
                charCnt['x' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['g' - 'a']) > 0){
                digitCnt[8] += cnt;
                charCnt['e' - 'a'] -= cnt;
                charCnt['i' - 'a'] -= cnt;
                charCnt['g' - 'a'] -= cnt;
                charCnt['h' - 'a'] -= cnt;
                charCnt['t' - 'a'] -= cnt;
            }

            // 第二轮，由于第一轮中2、4、6、8、0已经被尽可能地找出来，因此第二轮可以根据o, r, f, s 判断出1 3 5 7的个数
            if ((cnt = charCnt['o' - 'a']) > 0){
                digitCnt[1] += cnt;
                charCnt['o' - 'a'] -= cnt;
                charCnt['n' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['r' - 'a']) > 0){
                digitCnt[3] += cnt;
                charCnt['t' - 'a'] -= cnt;
                charCnt['h' - 'a'] -= cnt;
                charCnt['r' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['f' - 'a']) > 0){
                digitCnt[5] += cnt;
                charCnt['f' - 'a'] -= cnt;
                charCnt['i' - 'a'] -= cnt;
                charCnt['v' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
            }
            if ((cnt = charCnt['s' - 'a']) > 0){
                digitCnt[7] += cnt;
                charCnt['s' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
                charCnt['v' - 'a'] -= cnt;
                charCnt['e' - 'a'] -= cnt;
                charCnt['n' - 'a'] -= cnt;
            }

            // 最后一轮 只可能为9
            cnt = charCnt['i' - 'a'];
            digitCnt[9] += cnt;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < digitCnt[i]; j++) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
