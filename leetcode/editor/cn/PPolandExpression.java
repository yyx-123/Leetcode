package editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PPolandExpression {

    static Map<Character, Integer> PRIORITY = new HashMap<>();

    static {
        PRIORITY.put('+', 1);
        PRIORITY.put('-', 1);
        PRIORITY.put('*', 2);
        PRIORITY.put('/', 2);
    }

    public static void main(String[] args) {
        System.out.println(midToBack("1*(2+3)"));
    }

    private static String midToBack(String s){
        // 用两个栈：nums和ops。其中ops用来存放各种操作数，但是nums并不是只存数字的
        Stack<String> nums = new Stack<>(), ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 1. 如果是数字，就直接入nums栈
            if (Character.isDigit(s.charAt(i))){
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;

                nums.push(s.substring(i, j));
                i = j - 1;
            }
            // 2. 如果是操作：
            else{
                // 2.1 如果ops空，则直接入ops
                if (ops.isEmpty()){
                    ops.push(s.substring(i, i + 1));
                    continue;
                }

                // 2.2 如果操作是（，则直接入ops
                if (s.charAt(i) == '('){
                    ops.push(s.substring(i, i + 1));
                    continue;
                }

                // 2.3 如果操作是），则把ops中的操作全都出栈入栈到nums中，直到遇到左括号（
                if (s.charAt(i) == ')'){
                    while (!ops.peek().equals("(")){
                        nums.push(ops.pop());
                    }
                    ops.pop();  // 把左括号弹出丢弃
                    continue;
                }

                // 2.4 如果操作是+、-、*、/
                // 2.4.1 如果栈顶为（，或者栈顶元素优先级比较小；则直接入ops
                if (ops.peek().equals("(") || PRIORITY.get(ops.peek()) < PRIORITY.get(s.charAt(i))){
                    ops.push(s.substring(i, i + 1));
                }
                // 2.4.2 如果栈顶元素不为（，且优先级更大；则重复2.3的过程
                else{
                    while (!ops.peek().equals("(")){
                        nums.push(ops.pop());
                    }
                    ops.pop();
                }
            }
        }
        // 把ops剩余的元素全都出栈入栈到nums中。这时nums从底到顶的顺序就是后缀波兰表达式的顺序
        while (!ops.isEmpty()){
            nums.push(ops.pop());
        }

        Stack<String> tmp = new Stack<>();
        while (!nums.isEmpty()){
            tmp.push(nums.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!tmp.isEmpty()){
            sb.append(tmp.pop());
        }

        return sb.toString();
    }
}
