package editor.cn;
//给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。 
//
// 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成
//部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。 
//
// 请注意，返回的 规范路径 必须遵循下述格式： 
//
// 
// 始终以斜杠 '/' 开头。 
// 两个目录名之间必须只有一个斜杠 '/' 。 
// 最后一个目录名（如果存在）不能 以 '/' 结尾。 
// 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。 
// 
//
// 返回简化后得到的 规范路径 。 
//
// 
//
// 示例 1： 
//
// 
//输入：path = "/home/"
//输出："/home"
//解释：注意，最后一个目录名后面没有斜杠。 
//
// 示例 2： 
//
// 
//输入：path = "/../"
//输出："/"
//解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
// 
//
// 示例 3： 
//
// 
//输入：path = "/home//foo/"
//输出："/home/foo"
//解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
// 
//
// 示例 4： 
//
// 
//输入：path = "/a/./b/../../c/"
//输出："/c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= path.length <= 3000 
// path 由英文字母，数字，'.'，'/' 或 '_' 组成。 
// path 是一个有效的 Unix 风格绝对路径。 
// 
// Related Topics 栈 字符串 
// 👍 388 👎 0


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//2022-01-06 13:43:29
public class P71SimplifyPath{
    public static void main(String[] args) {
        Solution solution = new P71SimplifyPath().new Solution();
        // TO TEST
        System.out.println(solution.simplifyPath("/../"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public String simplifyPath(String path) {
            // 确保路径以/结尾
            path = path + "/";
            StringBuilder sb = new StringBuilder();
            int len = path.length();
            // 去除重复的斜杠
            for (int i = 0; i < len; i++) {
                if (path.charAt(i) == '/'){
                    int j = i + 1;
                    while (j < len && path.charAt(j) == '/') j++;
                    sb.append('/');
                    i = j - 1;
                }else{
                    sb.append(path.charAt(i));
                }
            }

            path = sb.toString();
            Stack<String> dirs = new Stack<>();
            int i = 0;
            while (i < path.length() - 1){
                int j = i + 1;

                while (j < path.length() && path.charAt(j) != '/') j++;

                String dir = path.substring(i + 1, j);
                if (dir.equals("..")){
                    if (!dirs.isEmpty())  dirs.pop();
                }else if (dir.equals(".")) {
                }
                else{
                    dirs.push(dir);
                }
                i = j;
            }

            Stack<String> newStack = new Stack<>();
            while (!dirs.isEmpty()){
                newStack.push(dirs.pop());
            }
            sb = new StringBuilder("/");
            while (!newStack.isEmpty()){
                sb.append(newStack.pop());
                if (newStack.size() > 0) sb.append("/");
            }
            return sb.toString();
        }
    }

    class Solution {
        public String simplifyPath(String path) {
            if (path.charAt(path.length() - 1) != '/') path += "/";

            char[] chars = path.toCharArray();
            int len = chars.length, i = 0;
            Deque<String> dq = new LinkedList<>();
            while (i < len - 1){
                int j = i + 1;

                while (j < len && chars[j] != '/') j++;

                String dir = String.valueOf(chars, i + 1, j - i - 1);
                if (dir.equals("..")){
                    if (!dq.isEmpty()) dq.pollLast();
                }else if (dir.equals(".")) {
                }else{
                    if (dir.length() > 0) dq.addLast(dir);
                }
                i = j;
            }
            StringBuilder sb = new StringBuilder("/");
            while (dq.size() > 0){
                sb.append(dq.pollFirst());
                if (dq.size() > 0) sb.append("/");
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
