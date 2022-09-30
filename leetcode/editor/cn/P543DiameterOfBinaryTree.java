package editor.cn;

public class P543DiameterOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            // 一个以root为根的树，其直径可能有两种情况：
            // 1. 直径经过root节点，则直径的长度为左子树的深度+右子树的深度
            // 2. 直径不经过root节点，则直径的长度为max(左子树的直径，右子树的直径)
            // 最终的直径为以上两种情况下，更大的那种，即max(情况1， 情况2)
            return Math.max(depth(root.left) + depth(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        }

        private int depth(TreeNode root){
            if (root == null) return 0;
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}