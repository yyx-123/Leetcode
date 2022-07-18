package editor.cn;
//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 109 
// 
// Related Topics 字典树 
// 👍 318 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

//2022-03-23 09:54:52
public class P440KThSmallestInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new P440KThSmallestInLexicographicalOrder().new Solution();
        // TO TEST
        System.out.println(solution.findKthNumber(10000, 10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthNumber(int n, int k) {

            PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
                return -1 * String.valueOf(i).compareTo(String.valueOf(j));
            });

            for (int i = 1; i <= n; i++) {
                if (pq.size() < k){
                    pq.add(i);
                }else{
                    if (String.valueOf(i).compareTo(String.valueOf(pq.peek()))  <= 0 ){
                        pq.poll();
                        pq.add(i);
                    }
                }

            }
            return pq.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
