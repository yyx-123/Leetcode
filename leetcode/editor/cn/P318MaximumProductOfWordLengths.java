package editor.cn;
//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 
// 👍 246 👎 0
	

//2021-11-17 13:21:56
public class P318MaximumProductOfWordLengths{
    public static void main(String[] args) {
        Solution solution = new P318MaximumProductOfWordLengths().new Solution();
        // TO TEST
        //String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        //String[] words = {"a","aa","aaa","aaaa"};
        System.out.println(solution.maxProduct(words));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 按照题意两两检查words中的每一对word是否存在字母重叠，不存在重叠的进一步计算长度积，找出最大值
     * 字幕重叠的检查方法是用一个boolean[26]的wordVector表示每一个word中出现的字母
     */
    /*class Solution {
        private boolean wordsOverlap(boolean[] wordVec1, boolean[] wordVec2){
            for (int i = 0; i < 26; i++) {
                if (wordVec1[i] && wordVec2[i]) return true;
            }
            return false;
        }

        public int maxProduct(String[] words) {
            int n = words.length;
            boolean[][] wordVecs = new boolean[n][26];
            for (int i = 0; i < n; i++) {
                String word = words[i];
                for (char c : word.toCharArray()){
                    wordVecs[i][c - 'a'] = true;
                }
            }

            int maxLen = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!wordsOverlap(wordVecs[i], wordVecs[j])){
                        maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                    }
                }
            }
            return maxLen;
        }
    }*/

    /**
     * 整体思路同上。只是在检查单词是否字母重叠上有所不同。这里的wordVec用一个int表示，其中最低的26位的每一位0或者1表示26个字母不出现或者出现
     * 在生成wordVec的过程中用循环移位和按位或的方法，比如字母c出现，则令1（00000000 00000000 00000000 00000001）左移2位得到00000000 00000000 00000000 00000100，再按位或
     * 检查是否字母重叠只需要按位与比较两个wordVec，按位与结果为0说明没有字母重叠
     * 由于位运算效率极高且避免了函数调用返回、逐位比较boolean【26】的向量，因此速度快很多
     */
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] wordVecs = new int[n];
            for (int i = 0; i < n; i++) {
                String word = words[i];
                for (char c : word.toCharArray()){
                    wordVecs[i] = wordVecs[i] | (1 << (c - 'a'));
                }
            }

            int maxLen = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((wordVecs[i] & wordVecs[j]) == 0){
                        maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                    }
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
