package editor.cn;
//在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。 
//
// 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表
//，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。 
//
// 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。 
//
// 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
//输出：false
//解释：
//从源方格无法到达目标方格，因为我们无法在网格中移动。
//无法向北或者向东移动是因为方格禁止通行。
//无法向南或者向西移动是因为不能走出网格。 
//
// 示例 2： 
//
// 
//输入：blocked = [], source = [0,0], target = [999999,999999]
//输出：true
//解释：
//因为没有方格被封锁，所以一定可以到达目标方格。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= blocked.length <= 200 
// blocked[i].length == 2 
// 0 <= xi, yi < 106 
// source.length == target.length == 2 
// 0 <= sx, sy, tx, ty < 106 
// source != target 
// 题目数据保证 source 和 target 不在封锁列表内 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 哈希表 
// 👍 113 👎 0




import java.util.*;

//2022-01-11 14:32:57
public class P1036EscapeALargeMaze{
    public static void main(String[] args) {
        Solution solution = new P1036EscapeALargeMaze().new Solution();
        // TO TEST
        int[][] blocked = {};
        System.out.println(solution.isEscapePossible(blocked, new int[]{0,0},new int[]{999, 999}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Postion{
            private int x;
            private int y;

            public Postion(int[] p){
                x = p[0];
                y = p[1];
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public boolean isOutOfRange(){
                return x < 0 || x > 1000000 || y < 0 || y > 1000000;
            }

            public List<Postion> neighours(){
                List<Postion> list = new ArrayList<>();
                list.add(new Postion(new int[]{x + 1, y}));
                list.add(new Postion(new int[]{x - 1, y}));
                list.add(new Postion(new int[]{x, y + 1}));
                list.add(new Postion(new int[]{x, y - 1}));

                return list;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Postion postion = (Postion) o;
                return x == postion.x &&
                        y == postion.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            HashSet<Postion> blockedPos = new HashSet<>();
            for (int[] p : blocked) blockedPos.add(new Postion(p));

            Postion tgtPostion = new Postion(target);

            Set<Postion> gone = new HashSet<>();

            Queue<Postion> q = new LinkedList<>();
            q.offer(new Postion(source));
            while (!q.isEmpty()){
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    Postion pos = q.poll();

                    if (pos.equals(tgtPostion)) return true;

                    List<Postion> neighours = pos.neighours();
                    for (Postion neighbour : neighours){
                        if (blockedPos.contains(pos) || gone.contains(pos) || pos.isOutOfRange()){
                            continue;
                        }else{
                            q.offer(neighbour);
                        }
                    }
                    gone.add(pos);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
