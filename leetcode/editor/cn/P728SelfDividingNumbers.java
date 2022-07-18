package editor.cn;
//自除数 是指可以被它包含的每一位数整除的数。 
//
// 
// 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。 
// 
//
// 自除数 不允许包含 0 。 
//
// 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 1, right = 22
//输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
// 
//
// 示例 2: 
//
// 
//输入：left = 47, right = 85
//输出：[48,55,66,77]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 104 
// 
// Related Topics 数学 
// 👍 175 👎 0


import java.util.LinkedList;
import java.util.List;

//2022-03-31 09:47:19
public class P728SelfDividingNumbers{
    public static void main(String[] args) {
        Solution solution = new P728SelfDividingNumbers().new Solution();
        // TO TEST
        System.out.println(solution.selfDividingNumbers(1, 22));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> rst = new LinkedList<>();
            for (int i = left; i <= right; i++) {
                if (check(i)) rst.add(i);
            }
            return rst;
        }

        private boolean check(int n){
            int original_n = n;
            while (n > 0){
                int digit = n % 10;
                if (digit == 0 || original_n % digit != 0) return false;
                n /= 10;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
