package dp1;

import java.util.*;
import java.io.*;

public class 함수실행 {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        w();
        while (true) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();
            int value;
            if (num1 == -1 && num2 == -1 && num3 == -1) break;
            if (num1 <= 0 || num2 <= 0 || num3 <= 0) value = 1;
            else if (num1 > 20 || num2 > 20 || num3 > 20) value = dp[20][20][20];
            else value = dp[num1][num2][num3];
            System.out.println("w(" + num1 + ", " + num2 + ", " + num3 + ") = " + value);
        }
    }

    public static void w() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) dp[i][j][k] = 1;
                    else if (i < j && j < k) dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }
    }

}
