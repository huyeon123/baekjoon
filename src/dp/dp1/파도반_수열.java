package dp.dp1;

import java.util.*;
import java.io.*;

public class 파도반_수열 {

    static int t, k;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            dp = new long[k];
            solution(k);
            System.out.println(dp[k - 1]);
        }

    }

    public static void solution(int k) {
        if (k < 5) {
            dp = new long[5];
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 5; i < k; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
    }

}
