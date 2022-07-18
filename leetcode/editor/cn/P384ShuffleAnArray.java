package editor.cn;
//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -106 <= nums[i] <= 106 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 104 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 
// 👍 211 👎 0


import java.util.Arrays;
import java.util.Random;

//2021-11-22 13:25:16
public class P384ShuffleAnArray{
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P384ShuffleAnArray().new Solution(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] origin;
        int N;
        Random random = new Random();

        public Solution(int[] nums) {
            N = nums.length;
            origin = nums.clone();
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            int[] shuffled = origin.clone();
            for (int i = 0; i < N; i++) {
                int randomIdx = random.nextInt(N - i) + i;
                int tmp = shuffled[i];
                shuffled[i] = shuffled[randomIdx];
                shuffled[randomIdx] = tmp;
            }
            return shuffled;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
