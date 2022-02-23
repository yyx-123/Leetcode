package editor.cn;
//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1122 👎 0


import java.util.Deque;
import java.util.LinkedList;

//2022-01-08 21:53:33
public class P226InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
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
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            TreeNode tmp = left;
            root.left = right;
            root.right = tmp;

            return root;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            Deque<TreeNode> dq = new LinkedList<>();
            dq.addFirst(root);
            while (!dq.isEmpty()){
                TreeNode node = dq.pollFirst();

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                if (node.left != null) dq.addFirst(node.left);
                if (node.right != null) dq.addFirst(node.right);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
