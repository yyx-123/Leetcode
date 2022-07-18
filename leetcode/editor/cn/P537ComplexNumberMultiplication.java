package editor.cn;
//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i2 == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 92 👎 0


import javax.imageio.ImageIO;

//2022-02-25 10:33:51
public class P537ComplexNumberMultiplication{
    public static void main(String[] args) {
        Solution solution = new P537ComplexNumberMultiplication().new Solution();
        // TO TEST
        System.out.println(solution.complexNumberMultiply("1+-1i","1+-1i"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private class ComplexNumber{

            int real;

            int imag;

            public ComplexNumber(){}

            public ComplexNumber(String s){
                if (s.contains("+")) {
                    real = Integer.parseInt(s.split("[+]")[0]);
                    imag = Integer.parseInt(s.split("[+]")[1].split("i")[0]);
                }else{
                    if (s.contains("i")){
                        real = 0;
                        imag = Integer.parseInt(s.split("i")[0]);
                    }else{
                        real = Integer.parseInt(s);
                        imag = 0;
                    }
                }
            }

            public ComplexNumber multiply(ComplexNumber num2){
                ComplexNumber rst = new ComplexNumber();
                rst.real = this.real * num2.real - this.imag * num2.imag;
                rst.imag = this.imag * num2.real + this.real * num2.imag;

                return rst;
            }

            @Override
            public String toString(){
                return real + "+" + imag + "i";
            }


        }

        public String complexNumberMultiply(String num1, String num2) {
            return (new ComplexNumber(num1).multiply(new ComplexNumber(num2))).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
