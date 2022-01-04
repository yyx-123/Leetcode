package editor.cn;
//列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法： 
//
// 
// 
// 
// 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。 
// 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。 
// 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 
// 
//
// 给你整数 n ，返回 arr 最后剩下的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 9
//输出：6
//解释：
//arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//arr = [2, 4, 6, 8]
//arr = [2, 6]
//arr = [6]
// 
//
// 示例 2： 
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
// 1 <= n <= 109 
// 
// 
// 
// Related Topics 数学 
// 👍 217 👎 0


import java.util.Deque;
import java.util.LinkedList;

//2022-01-02 16:16:31
public class P390EliminationGame{
    public static void main(String[] args) {
        Solution solution = new P390EliminationGame().new Solution();
        // TO TEST
        System.out.println(solution.lastRemaining(9));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 用两个栈倒来倒去模拟从左往右从右往左的过程，但是MLE了
    /*class Solution {
        public int lastRemaining(int n) {
            Deque<Integer> from = new LinkedList<>();
            for (int i = n; i > 0; i--) {
                from.offerLast(i);
            }

            Deque<Integer> to = new LinkedList<>();
            while (true){
                if (from.size() == 1) return from.removeLast();
                from.removeLast();
                if (from.size() == 1) return from.removeLast();

                boolean needSave = true;
                while (!from.isEmpty()){
                    int i = from.removeLast();
                    if (needSave) {
                        to.offerLast(i);
                    }
                    needSave = !needSave;
                }

                Deque<Integer> tmp = from;
                from = to;
                to = tmp;
            }
        }
    }*/

    // https://leetcode-cn.com/problems/elimination-game/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-k2uj/
    class Solution {
        public int lastRemaining(int n) {
            int head = 1, step = 1;
            boolean fromLeft = true;
            while (n > 1){
                if (fromLeft || n % 2 == 1){
                    head += step;
                }
                step *= 2;
                n /= 2;
                fromLeft = !fromLeft;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
