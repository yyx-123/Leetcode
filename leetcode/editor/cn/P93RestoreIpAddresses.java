package editor.cn;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 801 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//2022-02-24 14:11:20
public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
        System.out.println(solution.restoreIpAddresses("0000"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> rst = new LinkedList<>();

        int len = 0;

        char[] chars;

        public List<String> restoreIpAddresses(String s) {
            chars = s.toCharArray();
            len = s.length();
            int dots2insert = 3;
            List<Integer> insertePos = new ArrayList<>();

            backtrack(dots2insert, insertePos);

            return rst;
        }

        private void backtrack(int dots2insert, List<Integer> insertePos) {
            if (dots2insert == 0){
                if (isAvailable(insertePos)){
                    int len1 = insertePos.get(0) + 1;
                    int len2 = insertePos.get(1) - insertePos.get(0);
                    int len3 = insertePos.get(2) - insertePos.get(1);
                    int len4 = chars.length - insertePos.get(2) - 1;

                    int a = Integer.parseInt(String.valueOf(chars, 0, len1));
                    int b = Integer.parseInt(String.valueOf(chars, insertePos.get(0) + 1, len2));
                    int c = Integer.parseInt(String.valueOf(chars, insertePos.get(1) + 1, len3));
                    int d = Integer.parseInt(String.valueOf(chars, insertePos.get(2) + 1, len4));

                    StringBuilder sb = new StringBuilder();
                    sb.append(a).append('.').append(b).append('.').append(c).append('.').append(d);
                    rst.add(sb.toString());
                }
                return;
            }


            for (int i = 0; i < chars.length - 1; i++) {
                if (insertePos.size() == 0 || insertePos.get(insertePos.size() - 1) < i){

                    insertePos.add(i);
                    dots2insert--;

                    backtrack(dots2insert, insertePos);

                    dots2insert++;
                    insertePos.remove(insertePos.size() - 1);
                }
            }
        }

        private boolean isAvailable(List<Integer> insertePos) {
            int len1 = insertePos.get(0) + 1;
            int len2 = insertePos.get(1) - insertePos.get(0);
            int len3 = insertePos.get(2) - insertePos.get(1);
            int len4 = chars.length - insertePos.get(2) - 1;


            if (len1 > 3 || len2 > 3 || len3 > 3 || len4 > 3) return false;

            int a = Integer.parseInt(String.valueOf(chars, 0, len1));
            int b = Integer.parseInt(String.valueOf(chars, insertePos.get(0) + 1, len2));
            int c = Integer.parseInt(String.valueOf(chars, insertePos.get(1) + 1, len3));
            int d = Integer.parseInt(String.valueOf(chars, insertePos.get(2) + 1, len4));

            if (a > 255 || b > 255 || c > 255 || d > 255) return false;

            // 有先导0
            if ((a < 100 && len1 == 3) || (a < 10 && len1 == 2)) return false;
            if ((b < 100 && len2 == 3) || (b < 10 && len2 == 2)) return false;
            if ((c < 100 && len3 == 3) || (c < 10 && len3 == 2)) return false;
            if ((d < 100 && len4 == 3) || (d < 10 && len4 == 2)) return false;

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
