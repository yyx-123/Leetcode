package editor.cn;
//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 317 👎 0


import java.util.*;

//2021-12-26 22:32:57
public class P187RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        // TO TEST
            String s = "AAAAAAAAAAA";
        System.out.println(solution.findRepeatedDnaSequences(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // 最原始的想法，即滑动窗口取出定长为10的子串，用一个Map记录该子串的出现次数。为了避免重复答案，子串出现次数恰等于2时将该子串记到rst中
    /*class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> rst = new ArrayList<>();
            HashMap<String, Integer> set = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sub = s.substring(i, i + 10);
                set.put(sub, set.getOrDefault(sub, 0) + 1);
                if (set.get(sub) == 2) rst.add(sub);
            }
            return rst;
        }
    }*/

    // 
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> rst = new ArrayList<>();
            if (s.length() < 10) return rst;

            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Character, Integer> dict = new HashMap<>();
            dict.put('A', 0);
            dict.put('C', 1);
            dict.put('G', 2);
            dict.put('T', 3);

            int code = 0;
            for (int i = 0; i < 10; i++) {
                code = code << 2;
                code = code | dict.get(s.charAt(i));
            }

            int clearHigher = (1 << 20) - 1;
            for (int i = 0; i <= s.length() - 10; i++) {
                map.put(code, map.getOrDefault(code, 0) + 1);
                if (map.get(code) == 2) rst.add(decode(code));

                code = code << 2;
                if (i < s.length() - 10) code = code | dict.get(s.charAt(i + 10));
                code = code & clearHigher;

            }
            return rst;

        }

        private String decode(int code) {
            Character[] dict = {'A', 'C', 'G', 'T'};

            Deque<Character> q = new LinkedList<>();

            for (int i = 0; i < 10; i++) {
                char c = dict[3 & code];
                q.offerLast(c);
                code = code >> 2;
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()){
                sb.append(q.pollLast());
            }

            return sb.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
