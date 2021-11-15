package editor.cn;
//初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。 
//
// 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后
//一个灯泡的开关。 
//
// 找出并返回 n 轮后有多少个亮着的灯泡。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3
//输出：1 
//解释：
//初始时, 灯泡状态 [关闭, 关闭, 关闭].
//第一轮后, 灯泡状态 [开启, 开启, 开启].
//第二轮后, 灯泡状态 [开启, 关闭, 开启].
//第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 
//
//你应该返回 1，因为只有一个灯泡还亮着。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 脑筋急转弯 数学 
// 👍 223 👎 0
	

//2021-11-15 10:12:39
public class P319BulbSwitcher{
    public static void main(String[] args) {
        Solution solution = new P319BulbSwitcher().new Solution();
        // TO TEST
        System.out.println(solution.bulbSwitch(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int bulbSwitch(int n) {
            if (n == 0 || n == 1) return n;

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int switch_cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if ((i + 1) % j == 0) switch_cnt++;
                }
                if (switch_cnt % 2 == 1) cnt++;
            }
            return cnt;
        }*/

        /*public int bulbSwitch(int n) {
            if (n == 0 || n == 1) return n;

            boolean[] isSwitchedOn = new boolean[n];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n / i; j++) {
                    isSwitchedOn[j * i - 1] = !isSwitchedOn[j * i - 1];
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (isSwitchedOn[i]) cnt++;
            }
            return cnt;
        }*/

        public int bulbSwitch(int n) {
            return (int)Math.sqrt(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
