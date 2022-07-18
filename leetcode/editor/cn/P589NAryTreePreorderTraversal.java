package editor.cn;
//给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
//示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围 [0, 104]内 
// 0 <= Node.val <= 104 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
// Related Topics 栈 树 深度优先搜索 
// 👍 206 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//2022-02-15 16:08:56
public class P589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public List<Integer> preorder(Node root) {
            List<Integer> rst = new LinkedList<>();

            preorderTraverse(root, rst);
            return rst;
        }

        private void preorderTraverse(Node root, List<Integer> rst) {
            if (root == null) return;

            rst.add(root.val);
            for (Node child : root.children) {
                preorderTraverse(child, rst);
            }
        }
    }

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> rst = new LinkedList<>();
            if (root == null) return rst;

            Deque<Node> dq = new LinkedList<>();
            dq.addFirst(root);
            while (!dq.isEmpty()){
                Node node = dq.pollFirst();

                rst.add(node.val);
                int n = node.children.size();
                for (int i = n - 1; i >= 0; i--) {
                    dq.addFirst(node.children.get(i));
                }
            }
            return rst;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
