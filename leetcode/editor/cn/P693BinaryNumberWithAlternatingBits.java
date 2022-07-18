package editor.cn;
//给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：true
//解释：5 的二进制表示是：101
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：false
//解释：7 的二进制表示是：111. 
//
// 示例 3： 
//
// 
//输入：n = 11
//输出：false
//解释：11 的二进制表示是：1011. 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 166 👎 0
	

//2022-03-28 14:45:30
public class P693BinaryNumberWithAlternatingBits{
    public static void main(String[] args) {
        Solution solution = new P693BinaryNumberWithAlternatingBits().new Solution();
        // TO TEST
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        long mask = n % 2 == 1 ? 1 : 2;

        boolean shouldOne = true;
        while (mask <= n){
            if (shouldOne){
                // 这一位应该是1，但是按位与发现是0
                if ((mask & n) == 0){
                    return false;
                }
            }else{
                if ((mask & n) != 0){
                    return false;
                }
            }
            shouldOne = !shouldOne;
            mask <<= 1;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
