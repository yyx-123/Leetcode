package editor.cn;
//有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就
//是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] =
//= 0 表示。 
//
// 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。 
//
// 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。 
//
// 
//
// 示例 1： 
//
// 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
//输出：7
//解释：你可以吃掉 7 个苹果：
//- 第一天，你吃掉第一天长出来的苹果。
//- 第二天，你吃掉一个第二天长出来的苹果。
//- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
//- 第四天到第七天，你吃的都是第四天长出来的苹果。
// 
//
// 示例 2： 
//
// 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
//输出：5
//解释：你可以吃掉 5 个苹果：
//- 第一天到第三天，你吃的都是第一天长出来的苹果。
//- 第四天和第五天不吃苹果。
//- 第六天和第七天，你吃的都是第六天长出来的苹果。
// 
//
// 
//
// 提示： 
//
// 
// apples.length == n 
// days.length == n 
// 1 <= n <= 2 * 104 
// 0 <= apples[i], days[i] <= 2 * 104 
// 只有在 apples[i] = 0 时，days[i] = 0 才成立 
// 
// Related Topics 贪心 数组 堆（优先队列） 
// 👍 110 👎 0


import java.util.PriorityQueue;

//2021-12-24 14:47:50
public class P1705MaximumNumberOfEatenApples{
    public static void main(String[] args) {
        Solution solution = new P1705MaximumNumberOfEatenApples().new Solution();
        // TO TEST
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};

        System.out.println(solution.eatenApples(apples,days));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            // 小顶堆。存放的是二元组【苹果过期的日子，苹果的数量】，苹果过期日子最小（即最早）的二元组放在最上面
            // 每次取出的时候都会取出最先会过期的苹果
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int n = apples.length;

            int day = 0;
            int rst = 0;
            while (day < n || !q.isEmpty()){
                // 以下情况说明当天有苹果产生，将二元组入队
                if (day < n && apples[day] > 0){
                    q.add(new int[]{day + days[day] - 1, apples[day]});
                }
                // 这个循环不断地看堆顶元素是否过期，如果过期了就丢弃
                while (!q.isEmpty() && q.peek()[0] < day) q.poll();
                // 当天取出一个苹果吃掉，结果+1，且更新二元组中的苹果数量，如果苹果数量为0了则说明吃完了不用再放回队列了
                if (!q.isEmpty()){
                    int[] poll = q.poll();
                    rst++;
                    poll[1]--;
                    if (poll[1] > 0) q.add(poll);
                }
                day++;
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
