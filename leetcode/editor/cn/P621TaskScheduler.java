package editor.cn;

import java.util.Arrays;

public class P621TaskScheduler{
    public static void main(String[] args){
        Solution solution = new P621TaskScheduler().new Solution();
        System.out.println(solution.leastInterval(new char[]{'A','A','A'}, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) return tasks.length;

            int[] cnt = new int[26];
            int max = -1;
            for (char task : tasks) {
                cnt[task - 'A']++;
                max = Math.max(max, cnt[task - 'A']);
            }
            int maxCnt = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == max){
                    maxCnt++;
                }
            }

            return Math.max(tasks.length, (n + 1) * (max - 1) + maxCnt);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}