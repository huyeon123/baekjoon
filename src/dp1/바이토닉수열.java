package dp1;

import java.util.*;
import java.io.*;

public class 바이토닉수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1) System.out.println(1);
        else solution(arr, n);
    }

    public static void solution(int[] arr, int n) {
        int[][] dp = new int[n][2]; //0은 정방향 오름차순, 1은 역방향 오름차순

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp[i][1] < dp[j][1] + 1){
                    dp[i][1] = dp[j][1] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[i][0] + dp[i][1] - 1, answer);
        }

        System.out.println(answer);
    }

}
