package editor.cn;
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 1051 👎 0


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//2021-12-15 16:51:41
public class P207CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
        int[][] pres = {{3,0},{3,1},{4,1},{4,2},{5,3},{5,4}};
        System.out.println(solution.canFinish(6, pres));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, HashSet<Integer>> map = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                map.put(i, new HashSet<>());
            }

            for (int[] relation : prerequisites){
                HashSet<Integer> pres = map.get(relation[0]);
                pres.add(relation[1]);
                map.put(relation[0], pres);
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (map.get(i).size() == 0) q.offer(i);
            }

            boolean[] learned = new boolean[numCourses];
            int learnedCnt = 0;
            while (!q.isEmpty()){
                int course = q.poll();
                learned[course] = true;
                learnedCnt++;

                for (int i = 0; i < numCourses; i++) {
                    if (learned[i]) continue;

                    HashSet<Integer> pres = map.get(i);
                    if (pres.contains(course)) {
                        pres.remove(course);
                        if (pres.size() == 0) q.offer(i);
                    }
                    map.put(i, pres);
                }
            }

            return numCourses == learnedCnt;
        }
    }*/

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegrees = new int[numCourses];
            boolean[][] adj = new boolean[numCourses][numCourses];

            for (int[] relation : prerequisites){
                adj[relation[1]][relation[0]] = true;
                inDegrees[relation[0]]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) q.add(i);
            }
            int learedCnt = 0;
            while (!q.isEmpty()){
                int course = q.poll();
                learedCnt++;

                for (int i = 0; i < numCourses; i++) {
                    if (adj[course][i]){
                        adj[course][i] = false;
                        inDegrees[i]--;
                        if (inDegrees[i] == 0) q.add(i);
                    }
                }

            }

            return learedCnt == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
