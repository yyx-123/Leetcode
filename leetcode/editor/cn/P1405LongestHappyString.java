package editor.cn;
//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 
// 👍 101 👎 0


import java.util.*;

//2022-02-07 11:14:27
public class P1405LongestHappyString{
    public static void main(String[] args) {
        Solution solution = new P1405LongestHappyString().new Solution();
        // TO TEST
        System.out.println(solution.longestDiverseString(2,2,1));
        System.out.println(solution.longestDiverseString(1,1,7));
        System.out.println(solution.longestDiverseString(7,1,0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {return y[1] - x[1];});
            if (a > 0) pq.add(new int[]{0, a});
            if (b > 0) pq.add(new int[]{1, b});
            if (c > 0) pq.add(new int[]{2, c});

            List<Character> charList = new ArrayList<>();
            Queue<int[]> container = new LinkedList<>();
            while (!pq.isEmpty()){
                int[] temp = pq.poll();
                char ch = (char)(temp[0] + 'a');

                int len = charList.size();
                if (len < 2 || charList.get(len - 1) != charList.get(len - 2) || charList.get(len - 1) != ch){
                    charList.add(ch);
                    temp[1]--;
                    if (temp[1] > 0){
                        pq.add(temp);
                    }
                    while (!container.isEmpty()){
                        pq.add(container.poll());
                    }
                }else{
                    container.add(temp);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charList.size(); i++) {
                sb.append(charList.get(i));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
