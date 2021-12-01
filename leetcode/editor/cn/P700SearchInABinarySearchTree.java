package editor.cn;
//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 二叉搜索树 二叉树 
// 👍 206 👎 0
	

//2021-11-26 15:55:29
public class P700SearchInABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P700SearchInABinarySearchTree().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode rst = solution.searchBST(root, 5);
        System.out.println(123);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

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
    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;

            if (root.val < val) return searchBST(root.right, val);
            else if (root.val > val) return searchBST(root.left, val);
            else return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
