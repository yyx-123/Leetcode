package editor.cn;
//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 
// 👍 243 👎 0


import java.util.ArrayList;
import java.util.List;

//2021-12-13 11:46:11
public class P68TextJustification{
    public static void main(String[] args) {
        Solution solution = new P68TextJustification().new Solution();
        // TO TEST
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        // String[] words = {"What","must","be","acknowledgment","shall","be"};
        // String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = solution.fullJustify(words, 16);
        for (String l : list) System.out.println(l);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Line{
            int wordsCharCnt = 0;
            int maxWidth;
            ArrayList<String> wordsInLine = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            Line(int max) {maxWidth = max;}

            public void justify(){
                int wordsCnt = wordsInLine.size();

                if (wordsCnt == 1){
                    sb.append(wordsInLine.get(0));
                    for (int i = 0; i < maxWidth - wordsCharCnt; i++) {
                        sb.append(' ');
                    }
                    return;
                }

                int[] spaces = new int[wordsCnt - 1];
                int totalSpaces = maxWidth - wordsCharCnt, baseSpaces = totalSpaces / spaces.length;
                int remainSpaces = totalSpaces - baseSpaces * spaces.length;

                for (int i = 0; i < wordsCnt; i++) {
                    sb.append(wordsInLine.get(i));
                    if (i < wordsCnt - 1){
                        for (int j = 0; j < baseSpaces; j++)  sb.append(' ');
                        if (i <= remainSpaces - 1) sb.append(' ');
                    }
                }
            }

            public void finalJustify(){
                sb = new StringBuilder();
                for (int i = 0; i < wordsInLine.size(); i++) {
                    sb.append(wordsInLine.get(i));
                    if (i < wordsInLine.size() - 1) sb.append(' ');
                }
                int remainSpaces = maxWidth - sb.length();
                for (int i = 0; i < remainSpaces; i++) {
                    sb.append(' ');
                }
            }

            public void add(String word){
                wordsInLine.add(word);
                wordsCharCnt += word.length();
            }

            public boolean canAdd(String word){
                if (wordsCharCnt + word.length() + wordsInLine.size() <= maxWidth) return true;
                else return false;
            }

            public String toString(){return sb.toString();}
        }

        public List<String> fullJustify(String[] words, int maxWidth) {
            List<Line> lines = new ArrayList<>();

            Line line = new Line(maxWidth);
            for (String word : words){
                if (line.canAdd(word)) line.add(word);
                else {
                    line.justify();
                    lines.add(line);
                    line = new Line(maxWidth);
                    line.add(word);
                }
            }
            lines.add(line);

            lines.get(lines.size() - 1).finalJustify();
            ArrayList<String> rst = new ArrayList<>();
            for (Line l : lines){
                rst.add(l.toString());
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
