package editor.cn;
//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 1018 - 1] 范围内的整数 
// 
// Related Topics 数学 字符串 
// 👍 211 👎 0
	

//2022-03-02 21:00:26
public class P564FindTheClosestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P564FindTheClosestPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.nearestPalindromic("123"));
        System.out.println(solution.nearestPalindromic("8998"));
        System.out.println(solution.nearestPalindromic("8668"));
        System.out.println(solution.nearestPalindromic("80708"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nearestPalindromic(String n) {
            int len = n.length();
            if (len == 1) return String.valueOf(Integer.parseInt(n) - 1);

            if (isPalindromic(n)){
                char[] digits = n.toCharArray();

                char digit = digits[len / 2 - 1];
                if (digit == '0'){
                    digits[len / 2 - 1] = '1';
                    digits[(len + 1) / 2] = '1';
                }else{
                    digits[len / 2 - 1] = (char)(digit - 1);
                    digits[(len + 1) / 2] = (char)(digit - 1);
                }
                return String.valueOf(digits);
            }

            if (check(n)){
                return String.valueOf(Integer.parseInt(n) - 1);
            }


            char[] digits1 = n.toCharArray();
            for (int i = 0; i <= (len - 1) / 2; i++) {
                digits1[len - 1 - i] = digits1[i];
            }
            int val1 = Integer.parseInt(String.valueOf(digits1));

            char[] digits2 = n.toCharArray();
            for (int i = 0; i <= (len - 1) / 2; i++) {
                digits2[i] = digits2[len - 1 - i];
            }
            int val2 = Integer.parseInt(String.valueOf(digits2));

            int val = Integer.parseInt(n);
            if (Math.abs(val1 - val) < Math.abs(val2 - val)){
                return String.valueOf(val1);
            }else{
                return String.valueOf(val2);
            }
        }

        private boolean check(String n) {
            if (n.charAt(0) != '1') return false;
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) != '0') return false;
            }
            return true;
        }

        private boolean isPalindromic(String n){
            char[] chars = n.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
