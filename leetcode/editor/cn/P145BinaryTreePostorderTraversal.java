package editor.cn;
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 755 👎 0


import java.util.*;

//2022-02-15 15:39:00
public class P145BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> rst = new ArrayList<>();
            if (root == null) return rst;

            Deque<TreeNode> dq = new LinkedList<>();
            dq.addFirst(root);
            while (!dq.isEmpty()){
                TreeNode node = dq.pollFirst();
                rst.add(node.val);

                if (node.left != null){
                    dq.addFirst(node.left);
                }
                if (node.right != null){
                    dq.addFirst(node.right);
                }
            }
            Collections.reverse(rst);
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
