package dp.dp2;

import java.util.*;
import java.io.*;

public class 양팔저울 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[15000 + 1]; //추 최대무게 500g x 최대 개수 30개
        dp[0] = true;

        for (int weight : weights) {
            HashSet<Integer> available = new HashSet<>();
            available.add(weight);
            for (int j = 0; j < dp.length; j++) {
                if (dp[j]) {
                    if (j + weight <= 15000) available.add(j + weight);
                    int abs = Math.abs(j - weight);
                    if (abs <= 15000) available.add(abs);
                }
            }
            for (Integer integer : available) {
                dp[integer] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int marble = Integer.parseInt(st.nextToken());
            if (marble > 15000) sb.append("N");
            else{
                if (dp[marble]) sb.append("Y");
                else sb.append("N");
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }

}
