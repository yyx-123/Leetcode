package editor.cn;
//有两种特殊字符： 
//
// 
// 第一种字符可以用一个比特 0 来表示 
// 第二种字符可以用两个比特(10 或 11)来表示、 
// 
//
// 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。 
//
// 
//
// 示例 1: 
//
// 
//输入: bits = [1, 0, 0]
//输出: true
//解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入: bits = [1, 1, 1, 0]
//输出: false
//解释: 唯一的编码方式是两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] == 0 or 1 
// 
// Related Topics 数组 
// 👍 216 👎 0
	

//2022-02-20 09:26:06
public class P717OneBitAnd2BitCharacters{
    public static void main(String[] args) {
        Solution solution = new P717OneBitAnd2BitCharacters().new Solution();
        // TO TEST
        System.out.println(solution.isOneBitCharacter(new int[] {1, 1, 1, 0}));
        System.out.println(solution.isOneBitCharacter(new int[] {1, 0, 0}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            if (bits.length == 1) return true;
            else if (bits.length == 2 && bits[0] == 1) return false;
            else if (bits.length == 2 && bits[0] == 0) return true;

            int len = bits.length, i = 0;
            for (; i < len - 1; i++) {
                if (bits[i] == 1) i += 1;
            }

            return i == len - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
