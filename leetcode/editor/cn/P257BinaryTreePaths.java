package editor.cn;
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 
// 👍 646 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//2022-02-16 15:13:50
public class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = solution.binaryTreePaths(root);
        System.out.println(paths);
    }
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
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        TreeNode root;
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();
            this.root = root;

            if (root == null) return paths;

            List<Integer> curPath = new ArrayList<>();
            dfs(root, curPath, paths);
            return paths;
        }

        private void dfs(TreeNode node, List<Integer> curPath, List<String> paths) {
            curPath.add(node.val);

            if (node.left == null && node.right == null){
                StringBuilder sb = new StringBuilder();
                sb.append(curPath.get(0));
                for (int i = 1; i < curPath.size(); i++) {
                    sb.append("->");
                    sb.append(curPath.get(i));
                }
                paths.add(sb.toString());

                return;
            }


            if (node.left != null) {
                dfs(node.left, curPath, paths);
                curPath.remove(curPath.size() - 1);
            }
            if (node.right != null){
                dfs(node.right, curPath, paths);
                curPath.remove(curPath.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
