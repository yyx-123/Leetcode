package editor.cn;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 728 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//2022-02-15 15:13:48
public class P144BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        // TO TEST
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // 递归写法
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> rst = new ArrayList<>();

            preorder(root, rst);
            return rst;
        }

        private void preorder(TreeNode root, List<Integer> rst) {
            if (root == null) return;

            rst.add(root.val);
            preorder(root.left, rst);
            preorder(root.right, rst);
        }
    }

    // 迭代写法
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> rst = new ArrayList<>();
            if (root == null) return rst;

            Deque<TreeNode> dq = new LinkedList<>();

            dq.addFirst(root);
            while (!dq.isEmpty()){
                TreeNode node = dq.pollFirst();
                rst.add(node.val);
                if (node.right != null){
                    dq.addFirst(node.right);
                }
                if (node.left != null){
                    dq.addFirst(node.left);
                }
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
