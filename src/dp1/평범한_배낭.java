package dp1;

import java.util.*;
import java.io.*;

public class 평범한_배낭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        solution(w, v, n, k);
    }

    public static void solution(int[] w, int[] v, int n, int k) {
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            // K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
            for (int j = k; j - w[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[k]);
    }

}
