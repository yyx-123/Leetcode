package editor.cn;
//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|'
// 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[left
//i...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 105 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 105 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
// Related Topics 数组 字符串 二分查找 前缀和 
// 👍 115 👎 0


import java.util.*;

//2022-03-08 21:30:14
public class P2055PlatesBetweenCandles{
    public static void main(String[] args) {
        Solution solution = new P2055PlatesBetweenCandles().new Solution();
        // TO TEST
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        System.out.println(Arrays.toString(solution.platesBetweenCandles(s, queries)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            List<Integer> candlePos = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '|') candlePos.add(i);
            }
            
            int[] rst = new int[queries.length];
            for (int i = 0; i < rst.length; i++) {
                int[] query = queries[i];

                int startIdx = 0;
                while (startIdx < candlePos.size()){
                    if (candlePos.get(startIdx) < query[0]) startIdx++;
                    else break;
                }
                int endIdx = startIdx;
                while (endIdx < candlePos.size() - 1){
                    if (candlePos.get(endIdx + 1) <= query[1]) endIdx++;
                    else break;
                }

                if (startIdx == endIdx) {
                    rst[i] = 0;
                    continue;
                }
                for (int j = startIdx; j < endIdx; j++) {
                    rst[i] += candlePos.get(j + 1) - candlePos.get(j) - 1;
                }
            }
            return rst;
        }
    }

    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] preSum = new int[s.length()];

            int firstCandle = 0;
            while (firstCandle < s.length() && s.charAt(firstCandle) != '|') firstCandle++;

            int lastCandle = firstCandle;
            for (int i = firstCandle + 1; i < s.length(); i++) {
                if (s.charAt(i) == '|') {
                    preSum[i] = preSum[lastCandle] + (i - lastCandle - 1);
                    lastCandle = i;
                } else {
                    preSum[i] = preSum[i - 1];
                }
            }

            int[] rst = new int[queries.length];
            for (int i = 0; i < rst.length; i++) {
                int[] query = queries[i];

                rst[i] = preSum[query[1]] - preSum[query[0]];
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
