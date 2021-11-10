package editor.cn;
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// 
// -107 <= k <= 107 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 20 👎 0


import java.util.HashMap;
import java.util.LinkedList;

//2021-11-10 20:42:15
public class Offer010{
    public static void main(String[] args) {
        Solution solution = new Offer010().new Solution();
        // TO TEST
        int[] nums = {0,0};
        int k = 0;
        System.out.println(solution.subarraySum(nums, k));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;

            int[] s = new int[n];
            HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

            s[0] = nums[0];
            LinkedList<Integer> list = new LinkedList<>();
            list.add(0);
            map.put(nums[0], list);

            list = map.containsKey(0) ? map.get(0) : new LinkedList<>();
            list.add(-1);
            map.put(0, list);
            for (int i = 1; i < n; i++) {
                s[i] = nums[i] + s[i - 1];
                LinkedList<Integer> l;
                if (map.containsKey(s[i])) {
                    l = map.get(s[i]);
                }else{
                    l = new LinkedList<>();
                }
                l.add(i);
                map.put(s[i], l);
            }


            int rst = 0;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(s[i] - k)){
                    LinkedList<Integer> l = map.get(s[i] - k);
                    for (Integer integer : l){
                        if (integer < i) rst++;
                    }
                }
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
