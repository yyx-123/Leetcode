package editor.cn;

public class P538ConvertBstToGreaterTree{

    // Definition for a binary tree node.
    public static class TreeNode {
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

        /**
         * 为方便调试重写了tostring
         * @return
         */
        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public static void main(String[] args){
        Solution solution = new P538ConvertBstToGreaterTree().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode node = solution.convertBST(root);
        System.out.println(123);
    }
    //leetcode submit region begin(Prohibit modification and deletion)



    class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}