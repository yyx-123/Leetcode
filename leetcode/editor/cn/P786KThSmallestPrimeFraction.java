package editor.cn;
//给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。 
//
// 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。 
//
// 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == a
//rr[j] 。 
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,5], k = 3
//输出：[2,5]
//解释：已构造好的分数,排序后如下所示: 
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//很明显第三个最小的分数是 2/5
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,7], k = 1
//输出：[1,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 104 
// arr[0] == 1 
// arr[i] 是一个 素数 ，i > 0 
// arr 中的所有数字 互不相同 ，且按 严格递增 排序 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// Related Topics 数组 二分查找 堆（优先队列） 
// 👍 117 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//2021-11-29 09:25:29
public class P786KThSmallestPrimeFraction{
    public static void main(String[] args) {
        Solution2 solution = new P786KThSmallestPrimeFraction().new Solution2();
        // TO TEST
        int[] arr = {1,2,3,5};
        int k = 3;

        System.out.println(solution.kthSmallestPrimeFraction(arr, k)[0]);
        System.out.println(solution.kthSmallestPrimeFraction(arr, k)[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 解法1： 得到所有分数对，将所有结果保存在数组里并排序（需要实现好排序的接口等），最后输出第k个结果
    class Solution1 {
        class Node implements Comparable{
            private double val;
            private int[] nums = new int[2];

            Node(double v, int a, int b){
                val = v;
                nums[0] = a;
                nums[1] = b;
            }

            public double getVal() {
                return val;
            }

            public int[] getNums() {
                return nums;
            }

            @Override
            public int compareTo(Object o) {
                Node otherNode = (Node)o;
                return Double.compare(val, otherNode.getVal());
            }
        }

        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            ArrayList<Node> nodes = new ArrayList<>(n);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Node node = new Node((double)arr[i] / arr[j], arr[i] , arr[j]);
                    nodes.add(node);
                }
            }
            Collections.sort(nodes);
            return nodes.get(k - 1).getNums();
        }
    }

    // 解法2，同样得到所有的分数对，不过用一个最大堆（优先级队列实现）优化
    class Solution2 {
        class Node{
            private double val;
            private int[] nums = new int[2];

            Node(double v, int a, int b){
                val = v;
                nums[0] = a;
                nums[1] = b;
            }

            public double getVal() {
                return val;
            }

            public int[] getNums() {
                return nums;
            }
        }

        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            PriorityQueue<Node> pq = new PriorityQueue<>(k, (o1, o2) -> {
                if (o1.val < o2.val) return 1;
                else if (o1.val == o2.val) return 0;
                else return -1;
            });

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Node node = new Node((double)arr[i] / arr[j], arr[i] , arr[j]);

                    if (pq.size() < k)  pq.offer(node);
                    else {
                        if (node.val >= pq.peek().getVal()) continue;
                        else {
                            pq.poll();
                            pq.offer(node);
                        }
                    }
                }
            }
            return pq.poll().getNums();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
