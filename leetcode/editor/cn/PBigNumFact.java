package editor.cn;

public class PBigNumFact {
    public static void main(String[] args) {
        String n = "100000000000000", rst = n;
        while (!"1".equals(n)){
            rst = times(rst, decrease(n));
            n = decrease(n);
        }
        System.out.println(rst);
    }

    private static String times(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();

        String[] strings = new String[len2];

        for (int i = 0; i < len2; i++) {
            String str = "";
            for (int j = 0; j < i; j++) {
                str = str + "0";
            }

            int carry = 0, num2 = Integer.parseInt(s2.substring(len2 - i - 1, len2 - i));
            for (int j = len1 - 1; j >= 0; j--) {
                int num1 = Integer.parseInt(s1.substring(j, j + 1));

                int val = num1 * num2 + carry;
                carry = val / 10;
                str = (val % 10) + str;
            }
            if (carry > 0){
                str = carry + str;
            }


            strings[i] = str;
        }

        String rst = "";
        int carry = 0;
        for (int i = 0; i < strings[len2 - 1].length(); i++) {
            int sum = carry;
            for (int j = 0; j < len2; j++) {
                if (i >= strings[j].length()) continue;

                sum += Integer.parseInt(strings[j].substring(strings[j].length() - i - 1, strings[j].length() - i));
            }
            carry = sum / 10;
            rst = (sum % 10) + rst;
        }
        if (carry > 0){
            rst = carry + rst;
        }


        return rst;
    }

    private static String decrease(String s){
        if (s.charAt(s.length() - 1) != '0'){
            String rst = s.substring(0, s.length() - 1);
            rst = rst + (Integer.parseInt(s.substring(s.length() - 1)) - 1);
            return rst;
        }

        int i = 0;
        while (s.charAt(s.length() - 1 - i) == '0'){
            i++;
        }

        if (s.charAt(s.length() - i - 1) == '1'){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append('9');
            }
            return sb.toString();
        }else{
            String rst = decrease(s.substring(0, s.length() - i));
            for (int j = 0; j < i; j++) {
                rst = rst + "9";
            }
            return rst;
        }
    }
}
