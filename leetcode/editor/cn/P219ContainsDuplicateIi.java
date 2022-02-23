package editor.cn;
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 420 👎 0


import java.util.HashMap;

//2022-01-19 20:15:47
public class P219ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        // TO TEST
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();

            int i = 0;
            for (; i < Math.min(k + 1, n); i++) {
                int num = nums[i], cnt = map.getOrDefault(num, 0);
                if (cnt >= 1) return true;

                map.put(num, cnt + 1);
            }
            if (i == n) return false;
            for (; i < n; i++){
                if (nums[i] == nums[i - (k + 1)]) continue;

                if (map.getOrDefault(nums[i], 0) == 1) return true;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                map.put(nums[i - (k + 1)], map.getOrDefault(nums[i - (k + 1)], 0) - 1);
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
