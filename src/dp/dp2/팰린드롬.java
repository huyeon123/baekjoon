package dp.dp2;

import java.util.*;
import java.io.*;

public class 팰린드롬 {
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        dp = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, board);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (dp[start - 1][end - 1]) sb.append("1");
            else sb.append("0");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solution(int n, int[] board) {
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (board[i] == board[i+1]) dp[i][i + 1] = true;
        }

        for (int chunk = 2; chunk < n; chunk++) {
            for (int i = 0; i + chunk < n; i++) {
                if (dp[i + 1][i + chunk - 1] && board[i] == board[i + chunk]) {
                    dp[i][i + chunk] = true;
                }
            }
        }
    }

}
