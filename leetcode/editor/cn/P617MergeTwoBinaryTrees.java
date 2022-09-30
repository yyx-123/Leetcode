package editor.cn;

public class P617MergeTwoBinaryTrees{

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

    public static void main(String[] args){
        Solution solution = new P617MergeTwoBinaryTrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            else if (root1 == null) return root2;
            else if (root2 == null) return root1;
            else{
                TreeNode root = new TreeNode(root1.val + root2.val);
                root.left = mergeTrees(root1.left, root2.left);
                root.right = mergeTrees(root1.right, root2.right);
                return root;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}