package editor.cn;
//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 104 
// rectangles[i].length == 4 
// -105 <= xi, yi, ai, bi <= 105 
// 
// Related Topics 数组 扫描线 
// 👍 186 👎 0


import java.util.*;

//2021-11-16 21:08:18
public class P391PerfectRectangle{
    public static void main(String[] args) {
        Solution solution = new P391PerfectRectangle().new Solution();
        // TO TEST
        int[][] rectangles1 = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(solution.isRectangleCover(rectangles1));

        int[][] rectangles2 = {{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}};
        System.out.println(solution.isRectangleCover(rectangles2));

        int[][] rectangles3 = {{1,1,3,3},{3,1,4,2},{1,3,4,2},{3,2,4,4}};
        System.out.println(solution.isRectangleCover(rectangles3));

        int[][] rectangles4 = {{1,1,3,3},{3,1,4,2},{1,3,4,2},{2,2,4,4}};
        System.out.println(solution.isRectangleCover(rectangles4));

        int[][] rectangles5 = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(solution.isRectangleCover(rectangles5));

        int[][] rectangles6 = {{0,0,1,1},{0,0,2,1},{1,0,2,1},{0,2,2,3}};
        System.out.println(solution.isRectangleCover(rectangles6));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Point implements Comparable{
            private int x;
            private int y;

            Point(int a, int b){
                x = a;
                y = b;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }


            @Override
            public int compareTo(Object o) {
                Point otherP = (Point)o;
                if (x < otherP.x) return -1;
                else if (x > otherP.x) return 1;
                else {
                    if (y < otherP.y) return -1;
                    else if (y > otherP.y) return 1;
                    else return 0;
                }
            }
        }

        public boolean isRectangleCover(int[][] rectangles) {
            int n = rectangles.length;

            HashMap<Point, Integer> pointsCnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int[] rectangle = rectangles[i];
                Point leftBottomPoint = new Point(rectangle[0], rectangle[1]);
                Point leftUpPoint = new Point(rectangle[0], rectangle[3]);
                Point rightTopPoint = new Point(rectangle[2], rectangle[3]);
                Point rightBottomPoint = new Point(rectangle[2], rectangle[1]);
                pointsCnt.put(leftBottomPoint, pointsCnt.getOrDefault(leftBottomPoint, 0) + 1);
                pointsCnt.put(leftUpPoint, pointsCnt.getOrDefault(leftUpPoint, 0) + 1);
                pointsCnt.put(rightTopPoint, pointsCnt.getOrDefault(rightTopPoint, 0) + 1);
                pointsCnt.put(rightBottomPoint, pointsCnt.getOrDefault(rightBottomPoint, 0) + 1);
            }

            LinkedList<Point> cornerPoints = new LinkedList<>();
            for (Map.Entry<Point, Integer> entry : pointsCnt.entrySet()) {
                int appearedTime = entry.getValue();
                if (appearedTime == 1){
                    cornerPoints.add(entry.getKey());
                }else if (appearedTime % 2 == 0) continue;
                else return false;
            }

            if (cornerPoints.size() != 4) return false;
            Collections.sort(cornerPoints);
            return cornerPoints.get(0).getX() == cornerPoints.get(1).getX() && cornerPoints.get(2).getX() == cornerPoints.get(3).getX()
                    && cornerPoints.get(0).getY() == cornerPoints.get(2).getY() && cornerPoints.get(1).getY() == cornerPoints.get(3).getY();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
