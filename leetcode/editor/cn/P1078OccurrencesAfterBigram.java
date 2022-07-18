package editor.cn;
//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 se
//cond 紧随 first 出现，third 紧随 second 出现。 
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "alice is a good girl she is a good student", first = "a", second = 
//"good"
//输出：["girl","student"]
// 
//
// 示例 2： 
//
// 
//输入：text = "we will we will rock you", first = "we", second = "will"
//输出：["we","rock"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母和空格组成 
// text 中的所有单词之间都由 单个空格字符 分隔 
// 1 <= first.length, second.length <= 10 
// first 和 second 由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 52 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2021-12-26 14:12:14
public class P1078OccurrencesAfterBigram{
    public static void main(String[] args) {
        Solution solution = new P1078OccurrencesAfterBigram().new Solution();
        // TO TEST
        String text = "we will we will rock you", first = "we", second = "will";
        System.out.println(Arrays.toString(solution.findOcurrences(text, first, second)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] words = text.split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < words.length - 2; i++) {
                if (words[i].equals(first) && words[i + 1].equals(second)) list.add(words[i + 2]);
            }
            String[] rst =  new String[list.size()];
            for (int i = 0; i < rst.length; i++) {
                rst[i] = list.get(i);
            }
            return rst;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
