package editor.cn;

public class P647PalindromicSubstrings{
    public static void main(String[] args){
        Solution solution = new P647PalindromicSubstrings().new Solution();

        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int rst = 0;
            for (int i = 0; i < s.length(); i++) {
                rst += spread(s, i, i);
                rst += spread(s, i, i + 1);
            }
            return rst;
        }

        private int spread(String s, int left, int right){
            int cnt = 0;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                cnt++;
                left--;
                right++;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}