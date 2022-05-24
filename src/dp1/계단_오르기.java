package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {

    static int[] score, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        score = new int[n + 1]; //시작점까지 포함
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) score[i] = Integer.parseInt(br.readLine()); // 시작점은 0점

        dp[1] = score[1];
        if(n > 1) dp[2] = score[1] + score[2]; // n이 1이 입력된 경우 방지

        if(n > 2) solution(n);

        System.out.println(dp[n]);
    }

    public static void solution(int n) {
        // 바로 앞 계단을 통해 누적하려면, 앞 계단 점수가 한 칸 올라와서 얻은 점수인지 두 칸 올라와서 얻은 점수인지 알아야 한다
        // 이를 이용해 풀기에는 복잡해 지므로
        // 전전 계단에서 두 칸 올라오는 경우와 전전전 계단에서 두칸 올라온(이전 계단 점수)뒤 한칸 오르는 경우 중 높은 것 선택
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }
    }

}
