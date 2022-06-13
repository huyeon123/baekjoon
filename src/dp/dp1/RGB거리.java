package dp.dp1;

import java.util.*;
import java.io.*;

public class RGB거리 {

    static int n;
    static int[][] cost;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cost = new int[n][3]; // 각 집의 (RED, GREEN, BLUE) COST

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]));
    }

    // i번째 집까지 칠했을 때 최소 비용은
    // i-1번째 집과 색이 다르면서
    // 최소비용인 경우에 현재 색 비용 추가
    public static void solution() {
        for (int i = 1; i < n; i++) {
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }
    }

}
