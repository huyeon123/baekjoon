package dp1;

import java.util.*;
import java.io.*;

public class 연속합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) System.out.println(arr[0]);
        else solution(arr);

    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int ps = -1; //최근 양수였던 인덱스 번호
        int negativeSum = 0;
        int max = arr[0];

        dp[0] = arr[0];
        if (arr[0] > 0) ps = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (ps < 0) { //기존에 양수였던 수가 없으면, 그 값이 최대값
                    dp[i] = arr[i];
                }

                else {
                    //(최근 양수였던 수의 dp값 + ps 이후부터 현재 idx까지의 합(음수 합) + 현재 값) vs 현재 값
                    dp[i] = Math.max(0, dp[ps] + negativeSum) + arr[i];
                    negativeSum = 0;
                }
                ps = i; //현재 인덱스를 최신 양수 인덱스로 저장
            } else {
                negativeSum += arr[i]; //음수 합 계산
                dp[i] = Math.max(dp[i - 1], arr[i]); //0보다 작거나 같으면, 이전 dp값 그대로
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
