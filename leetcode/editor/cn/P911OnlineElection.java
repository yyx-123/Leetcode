package editor.cn;
//给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。 
//
// 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。 
//
// 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。 
//
// 实现 TopVotedCandidate 类： 
//
// 
// TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。 
// int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。 
// 
// 
//
// 示例： 
//
// 
//输入：
//["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
//[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [
//24], [8]]
//输出：
//[null, 0, 1, 1, 0, 0, 1]
//
//解释：
//TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1,
// 0], [0, 5, 10, 15, 20, 25, 30]);
//topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
//topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
//topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在
//平局的情况下，1 是最近获得投票的候选人）。
//topVotedCandidate.q(15); // 返回 0
//topVotedCandidate.q(24); // 返回 0
//topVotedCandidate.q(8); // 返回 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= persons.length <= 5000 
// times.length == persons.length 
// 0 <= persons[i] < persons.length 
// 0 <= times[i] <= 109 
// times 是一个严格递增的有序数组 
// times[0] <= t <= 109 
// 每个测试用例最多调用 104 次 q 
// 
// Related Topics 设计 数组 哈希表 二分查找 
// 👍 88 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

//2021-12-11 15:08:38
public class P911OnlineElection{
    public static void main(String[] args) {
        // TO TEST
        TopVotedCandidate topVotedCandidate = new P911OnlineElection().new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1,0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 解法1
    /*class TopVotedCandidate {
        private HashMap<Integer, ArrayList<Integer>> votes = new HashMap<>();
        private int[] votesCnt;

        public TopVotedCandidate(int[] persons, int[] times) {
            for (int i = 0; i < persons.length; i++) {
                int person = persons[i];
                ArrayList<Integer> list = votes.getOrDefault(person, new ArrayList());
                list.add(times[i]);
                votes.put(person, list);
            }
        }

        public int q(int t) {
            votesCnt = new int[votes.size()];
            int maxVote = Integer.MIN_VALUE;
            ArrayList<Integer> maxPerson = new ArrayList<>();
            for (int i = 0; i < votesCnt.length; i++) {
                votesCnt[i] = getVotes(i, t);
                if (votesCnt[i] > maxVote){
                    maxPerson = new ArrayList<>();
                    maxPerson.add(i);
                    maxVote = votesCnt[i];
                }else if (votesCnt[i] == maxVote) maxPerson.add(i);
            }

            if (maxPerson.size() == 1) return maxPerson.get(0);
            else{
                int newestTime = Integer.MIN_VALUE, newestPerson = -1;
                for (Integer person : maxPerson){
                    if (votes.get(person).get(maxVote - 1) > newestTime){
                        newestTime = votes.get(person).get(maxVote - 1);
                        newestPerson = person;
                    }
                }
                return newestPerson;
            }
        }

        private int getVotes(int person, int t) {
            ArrayList<Integer> vote = votes.get(person);
            int i = 0, j = vote.size() - 1;
            while (i <= j){
                int mid = i + (j - i) / 2;

                if (vote.get(mid) < t) i = mid + 1;
                else if (vote.get(mid) == t) return mid + 1;
                else j = mid - 1;
            }
            return j + 1;
        }
    }*/

    class TopVotedCandidate {
        ArrayList<int[]> list = new ArrayList<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            HashMap<Integer, Integer> votesCnt = new HashMap<>();
            int curMax = Integer.MIN_VALUE;

            for (int i = 0; i < persons.length; i++) {
                votesCnt.put(persons[i], votesCnt.getOrDefault(persons[i], 0) + 1);
                if (votesCnt.get(persons[i]) >= curMax){
                    curMax = votesCnt.get(persons[i]);
                    list.add(new int[]{times[i], persons[i]});
                }
            }
        }

        public int q(int t) {
            int i = 0, j = list.size() - 1;
            while (i <= j){
                int mid = i + (j - i) / 2;

                if (list.get(mid)[0] < t) i = mid + 1;
                else if (list.get(mid)[0] == t) return list.get(mid)[1];
                else{
                    j = mid - 1;
                }
            }
            return list.get(j)[1];
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
