package editor.cn;
//n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。 
//
// 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中： 
//
// 
// dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧， 
// dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧， 
// dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。 
// 
//
// 返回表示最终状态的字符串。 
// 
//
// 示例 1： 
//
// 
//输入：dominoes = "RR.L"
//输出："RR.L"
//解释：第一张多米诺骨牌没有给第二张施加额外的力。
// 
//
// 示例 2： 
//
// 
//输入：dominoes = ".L.R...LR..L.."
//输出："LL.RR.LLRRLL.."
// 
//
// 
//
// 提示： 
//
// 
// n == dominoes.length 
// 1 <= n <= 105 
// dominoes[i] 为 'L'、'R' 或 '.' 
// 
// Related Topics 双指针 字符串 动态规划 
// 👍 166 👎 0


import java.util.ArrayList;
import java.util.List;

//2022-02-21 10:13:40
public class P838PushDominoes{
    public static void main(String[] args) {
        Solution solution = new P838PushDominoes().new Solution();
        // TO TEST
        System.out.println(solution.pushDominoes("RR.L"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {
            // n:多米诺牌数
            int n = dominoes.length();
            // 在首尾做填充
            char[] domes = new char[n + 2];
            domes[0] = 'L';
            domes[n + 1] = 'R';
            for (int i = 0; i < n; i++) {
                domes[i + 1] = dominoes.charAt(i);
            }

            // i、j是双指针，len为填充后数组的长度
            int i = 0, j = 0, len = n + 2;
            while (i < len - 1){
                char start = domes[i];

                // 如果左边界为L
                if (start == 'L'){
                    // 找到右边第一个L牌或者R牌，记为end
                    j = i + 1;
                    while (j < len && domes[j] == '.') j++;

                    char end = domes[j];
                    // 如果end也为L，则在i和j之间的牌全部向左倒；如若不然，则为左L右R，不需要倒中间的任何牌
                    if (end == 'L'){
                        for (int k = i + 1; k < j; k++) {
                            domes[k] = 'L';
                        }
                    }
                    i = j;
                }
                // 如果左边界为R
                else if (start == 'R'){
                    // 找到右边第一个L牌或者R牌，记为end
                    j = i + 1;
                    while (j < len && domes[j] == '.') j++;

                    char end = domes[j];
                    // 如果end也为R，则在i和j之间的牌全部向右倒
                    if (end == 'R'){
                        for (int k = i + 1; k < j; k++) {
                            domes[k] = 'R';
                        }
                    }
                    // 如果end为L，则在i和j之间的牌全部向中间倒
                    else if (end == 'L'){
                        // 中间有一张牌站着，以这张牌为中心向两边修改状态（中心开花）
                        if ((j - i) % 2 == 0){
                            int mid = (i + j) / 2;
                            for (int k = 1; k <= (j - mid - 1); k++) {
                                domes[mid + k] = 'L';
                                domes[mid - k] = 'R';
                            }
                        }
                        // 没有中间那张牌，则从首尾两端向中间修改状态
                        else{
                            for (int k = 1; k <= (j - i) / 2; k++) {
                                domes[i + k] = 'R';
                                domes[j - k] = 'L';
                            }
                        }
                    }
                    i = j;
                }
            }
            // 去除domes数组中的中间段（去掉首尾两个辅助牌），生成String
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= n; k++) {
                sb.append(domes[k]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
