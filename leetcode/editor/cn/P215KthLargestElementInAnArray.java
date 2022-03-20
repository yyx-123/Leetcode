package editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1498 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//2022-03-02 10:26:31
public class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST

        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);

            return nums[nums.length - k];
        }
    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k);

            for (int num : nums) {
                if (pq.size() < k){
                    pq.add(num);
                }else{
                    if (pq.peek() < num){
                        pq.poll();
                        pq.add(num);
                    }
                }
            }
            return pq.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
