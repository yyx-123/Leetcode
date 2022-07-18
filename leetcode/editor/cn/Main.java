package editor.cn;

import java.util.Scanner;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        int n = Integer.parseInt(line);

        int[] nums = new int[n];
        String[] nums_ = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(nums_[i]);
        }

        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int rst = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int avg = (preSum[j] - preSum[i]) / (j - i);
                rst = Math.max(rst, avg);
            }
            rst = Math.max(rst, preSum[i] / (i + 1));
        }

        System.out.println(rst);
    }

}



