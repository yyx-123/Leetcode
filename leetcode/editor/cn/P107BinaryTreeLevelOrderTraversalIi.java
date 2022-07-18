package editor.cn;
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 534 👎 0


import java.util.*;

//2022-02-15 15:55:29
public class P107BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> rst = new ArrayList<>();
            if (root == null) return rst;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                List<Integer> level = new LinkedList<>();
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.poll();

                    level.add(node.val);
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
                rst.add(level);
            }
            Collections.reverse(rst);
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
