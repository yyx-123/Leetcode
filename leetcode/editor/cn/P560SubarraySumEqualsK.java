package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P560SubarraySumEqualsK{
    public static void main(String[] args){
        Solution solution = new P560SubarraySumEqualsK().new Solution();

        System.out.println(solution.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(solution.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(solution.subarraySum(new int[]{1}, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] presum = new int[n];
            Map<Integer, Integer> map = new HashMap<>();

            int rst = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0){
                    presum[i] = nums[0];
                }else{
                    presum[i] = presum[i - 1] + nums[i];
                }
                rst += map.getOrDefault(presum[i] - k, 0);
                if (presum[i] == k) rst++;

                Integer cnt = map.getOrDefault(presum[i], 0);
                map.put(presum[i], cnt + 1);
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}