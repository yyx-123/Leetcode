package editor.cn;
//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "F
//riday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 
// 👍 96 👎 0
	

//2022-01-03 20:26:49
public class P1185DayOfTheWeek{
    public static void main(String[] args) {
        Solution solution = new P1185DayOfTheWeek().new Solution();
        // TO TEST
        System.out.println(solution.dayOfTheWeek(28,2,2100));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {

            int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
            int n = (year - 1971) * 365 + days[month - 1] + day - 1;

            n += (year - 1968) / 4;
            if (year == 2100 || (year % 4 == 0 && month <= 2)) n--;

            // 1971.1.1是周五，所以table从周五开始
            String[] table = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
            return table[n % 7];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
