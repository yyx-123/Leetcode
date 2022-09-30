package editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class P739DailyTemperatures{
    public static void main(String[] args){
        Solution solution = new P739DailyTemperatures().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,60,90})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] rst = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    Integer pop = stack.pop();
                    rst[pop] = i - pop;
                }
                stack.push(i);
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}