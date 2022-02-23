package editor.cn;
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1367 👎 0


import java.util.Arrays;

//2022-01-09 13:23:53
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9, 3, 15, 20 ,7}));
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            if (preorder.length == 1) return new TreeNode(preorder[0]);

            int pivot = preorder[0];
            int pivotIdx = indexPiovot(inorder, pivot);

            TreeNode root = new TreeNode(pivot);
            root.left = buildTree(Arrays.copyOfRange(preorder,1, 1 + pivotIdx), Arrays.copyOfRange(inorder,0, pivotIdx));
            root.right = buildTree(Arrays.copyOfRange(preorder,1 + pivotIdx, preorder.length), Arrays.copyOfRange(inorder,1 + pivotIdx, preorder.length));
            return root;
        }

        private int indexPiovot(int[] inorder, int pivot) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == pivot){
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
