package editor.cn;
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 18 👎 0


import java.util.HashMap;

//2021-11-11 22:59:43
public class Offer011findMaxLength {
    public static void main(String[] args) {
        Solution solution = new Offer011findMaxLength().new Solution();
        // TO TEST
        // int[] nums = {0,1,1,0,1,1,1,0,1,0};
        int[] nums = {0,0,1};
        System.out.println(solution.findMaxLength(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            if (nums[0] == 0){
                sum[0] = -1;
                map.put(-1,0);
            }else{
                sum[0] = 1;
                map.put(1,0);
            }


            for (int i = 1; i < n; i++) {
                if (nums[i] == 0){
                    sum[i] = sum[i - 1] - 1;
                }else{
                    sum[i] = sum[i - 1] + 1;
                }

                if (!map.containsKey(sum[i])) {
                    map.put(sum[i], i);
                }
            }

            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(sum[i])) maxLen = Math.max(maxLen, i - map.get(sum[i]));
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
