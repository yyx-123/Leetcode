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


import java.util.Deque;
import java.util.LinkedList;

//2022-01-06 13:43:29
public class P71SimplifyPath{
    public static void main(String[] args) {
        Solution solution = new P71SimplifyPath().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> dq = new LinkedList<>();
            int i = 0, len = path.length();

            while (i < len){
                // 剔除最开始的斜杠（如果有连续的斜杠）
                while (i < len && path.charAt(i) == '/') i++;

                if (i == len) break;
                if (path.charAt(i) != '.'){
                    int j = i;
                    while (j < len && path.charAt(j) != '/') j++;
                    dq.offerLast(path.substring(i, j));
                    i = j;
                }else{
                    // './'为当前目录，直接忽略
                    if (i < len - 1 && path.charAt(i + 1) == '/') i += 2;
                    // '../'为上一层目录，在栈中弹出一层目录（如果栈非空）
                    else if (i < len - 2 && path.charAt(i = 1) == '.' && path.charAt(i + 2) == '.'){
                        if (dq.size() > 0) dq.removeLast();
                        i += 3;
                    }
                    // 其它情况，...及以上视为一个文件
                    else{
                        int j = i;
                        while (j < len && path.charAt(j) != '/') j++;
                        dq.offerLast(path.substring(i, j));
                        i = j;
                    }
                }
            }

            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
