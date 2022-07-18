package editor.cn;
//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 104 
// arr.length 是偶数 
// -105 <= arr[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 80 👎 0


import java.util.*;

//2022-04-01 08:55:29
public class P954ArrayOfDoubledPairs{
    public static void main(String[] args) {
        Solution solution = new P954ArrayOfDoubledPairs().new Solution();
        // TO TEST
        System.out.println(solution.canReorderDoubled(new int[]{1,3,3,6}));
        System.out.println(solution.canReorderDoubled(new int[]{4,-2,2,-4}));
        System.out.println(solution.canReorderDoubled(new int[]{2,4,0,0,8,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                if (num % 2 == 1){
                    if (map.containsKey(num * 2)){
                        Integer cnt = map.get(num * 2);

                        if (cnt == 1) map.remove(num * 2);
                        else map.put(num * 2, cnt - 1);
                    }else{
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                }else{
                    if (map.containsKey(num / 2)){
                        Integer cnt = map.get(num / 2);

                        if (cnt == 1) map.remove(num / 2);
                        else map.put(num / 2, cnt - 1);
                    }else if (map.containsKey(num * 2)){
                        Integer cnt = map.get(num * 2);

                        if (cnt == 1) map.remove(num * 2);
                        else map.put(num * 2, cnt - 1);
                    }else{
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                }
            }
            return map.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
