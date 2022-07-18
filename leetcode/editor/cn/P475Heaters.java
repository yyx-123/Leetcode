package editor.cn;
//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 104 
// 1 <= houses[i], heaters[i] <= 109 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 288 👎 0


import java.util.Arrays;

//2021-12-20 11:58:26
public class P475Heaters{
    public static void main(String[] args) {
        Solution solution = new P475Heaters().new Solution();
        // TO TEST
        int[] houses = {1, 5}, heaters = {10};
        System.out.println(solution.findRadius(houses, heaters));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int maxLen = -1;
            for (int housePosition : houses){
                int minDist = Integer.MAX_VALUE;
                for (int heaterPosition : heaters){
                    int dist = Math.abs(housePosition - heaterPosition);
                    minDist = Math.min(dist, minDist);
                    if (dist < maxLen) break;
                }
                maxLen = Math.max(maxLen, minDist);
            }
            return maxLen;
        }
    }*/

    /*class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int left = 0, right = Math.max(heaters[heaters.length - 1] - houses[0], houses[houses.length - 1] - heaters[0]);
            while (left < right){
                int mid = left + (right - left) / 2;

                if (isValid(mid, houses, heaters)) right = mid;
                else left = mid + 1;
            }
            return left;
        }

        private boolean isValid(int radius, int[] houses, int[] heaters) {
            int heatedCnt = 0;
            for (int house : houses){
                for (int heater : heaters){
                    if (house <= heater + radius && house >= heater - radius){
                        heatedCnt++;
                        break;
                    }
                }
            }
            return heatedCnt == houses.length;
        }
    }*/

    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);

            int[] myHeaters = new int[heaters.length + 2];
            myHeaters[0] = Integer.MIN_VALUE;
            myHeaters[myHeaters.length - 1] = Integer.MAX_VALUE;
            for (int i = 1; i < 1 + heaters.length; i++) {
                myHeaters[i] = heaters[i - 1];
            }

            int heaterP = 0;
            int rst = Integer.MIN_VALUE;
            for (int housePostion : houses){
                while (myHeaters[heaterP] < housePostion) heaterP++;
                int dist = Math.min(Math.abs(housePostion - myHeaters[heaterP - 1]), Math.abs(myHeaters[heaterP] - housePostion));
                rst = Math.max(dist, rst);
            }
            return rst;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
