package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n > 3) dp = new int[n + 1];
        else dp = new int[4];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        solution(n);
        System.out.println(dp[n]);
    }

    public static void solution(int n) {
        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 3], dp[i / 2])) + 1;
                } else {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                }
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else dp[i] = dp[i - 1] + 1;
        }
    }
}
