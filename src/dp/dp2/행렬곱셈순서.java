package dp.dp2;

import java.util.*;
import java.io.*;

public class 행렬곱셈순서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] mk = new int[n + 1][2];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mk[i][0] = Integer.parseInt(st.nextToken());
            mk[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int chunk = 1; chunk <= n; chunk++) {
            for (int start = 1; start + chunk <= n; start++) {
                int end = start + chunk;
                dp[start][end] = Integer.MAX_VALUE;
                for (int divide = start; divide < end; divide++) {
                    dp[start][end] = Math.min(
                            dp[start][end],
                            (mk[start][0] * mk[divide][1] * mk[end][1]) + dp[start][divide] + dp[divide + 1][end]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
