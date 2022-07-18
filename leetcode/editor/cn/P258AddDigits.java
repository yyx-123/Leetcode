package editor.cn;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 38
//输出: 2 
//解释: 各位相加的过程为：
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//由于 2 是一位数，所以返回 2。
// 
//
// 示例 1: 
//
// 
//输入: num = 0
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 231 - 1 
// 
//
// 
//
// 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 数论 模拟 
// 👍 425 👎 0
	

//2022-03-03 09:30:31
public class P258AddDigits{
    public static void main(String[] args) {
        Solution solution = new P258AddDigits().new Solution();
        // TO TEST
        System.out.println(solution.addDigits(0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            if (num < 10) return num;

            int newNum = 0;
            while (num > 0){
                newNum += num % 10;
                num /= 10;
            }

            return addDigits(newNum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
