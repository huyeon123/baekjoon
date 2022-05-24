package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) System.out.println(wine[0]);
        else if (n == 2) System.out.println(wine[0] + wine[1]);
        else System.out.println(solution(n, wine));
    }

    public static int solution(int n, int[] wine) {
        int[] dp = new int[n];
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(wine[i - 1] + dp[i - 3], dp[i - 2]) + wine[i]);
        }

        return dp[n - 1];
    }

}
