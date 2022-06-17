package dp.dp2;

import java.util.*;
import java.io.*;

public class 앱 {

    static int[] memory, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int target = Integer.parseInt(st1.nextToken());

        memory = new int[n];
        cost = new int[n];

        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int sum = 1;
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            sum += cost[i];
        }

        int[][] dp = new int[n][sum];
        for (int j = cost[0]; j < sum; j++) {
            dp[0][j] = memory[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < sum; j++) {
                if (j >= cost[i]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        for (int i = 0; i < dp[n - 1].length; i++) {
            if (dp[n - 1][i] >= target) {
                System.out.println(i);
                return;
            }
        }
    }
}
