package editor.cn;
//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 104 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 
// 👍 143 👎 0


import java.util.*;

//2022-01-18 12:01:38
public class P539MinimumTimeDifference{
    public static void main(String[] args) {
        Solution solution = new P539MinimumTimeDifference().new Solution();
        // TO TEST
        System.out.println(solution.findMinDifference(Arrays.asList("05:31","22:08","00:35")));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*class TimePoint implements Comparable{
            private int hour;
            private int min;

            public TimePoint(String timePoint){
                hour = Integer.parseInt(timePoint.split(":")[0]);
                min = Integer.parseInt(timePoint.split(":")[1]);
            }

            public int getHour() {
                return hour;
            }

            public int getMin() {
                return min;
            }

            public int diffWith(TimePoint t){
                return Math.abs((hour - t.getHour()) * 60 + min - t.getMin());
            }

            public TimePoint addOneDay(){
                hour += 24;
                return this;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                TimePoint timePoint = (TimePoint) o;
                return hour == timePoint.hour &&
                        min == timePoint.min;
            }

            @Override
            public int hashCode() {
                return Objects.hash(hour, min);
            }

            @Override
            public int compareTo(Object o) {
                if (hour != ((TimePoint) o).getHour()){
                    return hour - ((TimePoint) o).getHour();
                }else{
                    return min - ((TimePoint) o).getMin();
                }
            }

            @Override
            public String toString() {
                return "TimePoint{" +
                        "hour=" + hour +
                        ", min=" + min +
                        '}';
            }
        }

        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();
            List<TimePoint> times = new ArrayList<>();
            for (String s : timePoints) {
                times.add(new TimePoint(s));
            }

            Collections.sort(times);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i == n - 1){
                    minDiff = Math.min(minDiff, times.get(i).diffWith(times.get(0).addOneDay()));
                }else{
                    minDiff = Math.min(minDiff, times.get(i).diffWith(times.get(i + 1)));
                }
            }

            return minDiff;
        }*/

        public int[] parseTimeString(String s){
            return new int[]{Integer.parseInt(s.split(":")[0]), Integer.parseInt(s.split(":")[1])};
        }

        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();

            Collections.sort(timePoints, (t1, t2) -> {
                int h1 = Integer.parseInt(t1.split(":")[0]), h2 = Integer.parseInt(t2.split(":")[0]);
                int m1 = Integer.parseInt(t1.split(":")[1]), m2 = Integer.parseInt(t2.split(":")[1]);
                if (h1 == h2){
                    return m1 - m2;
                }else{
                    return h1 - h2;
                }
            });
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i == n - 1){
                    int diff = (parseTimeString(timePoints.get(0))[0] + 24 - parseTimeString(timePoints.get(i))[0]) * 60
                            + parseTimeString(timePoints.get(0))[1] - parseTimeString(timePoints.get(i))[1];
                    minDiff = Math.min(minDiff, diff);
                }else{
                    int diff = (parseTimeString(timePoints.get(i + 1))[0] - parseTimeString(timePoints.get(i))[0]) * 60
                            + parseTimeString(timePoints.get(i + 1))[1] - parseTimeString(timePoints.get(i))[1];
                    minDiff = Math.min(minDiff, diff);
                }
            }

            return minDiff;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
