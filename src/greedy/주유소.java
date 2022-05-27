package greedy;

import java.util.*;
import java.io.*;

public class 주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] distance = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < distance.length; i++) {
            distance[i] = distance[i - 1] + Integer.parseInt(st.nextToken());
        }

        long[] cost = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, distance, cost);
    }

    public static void solution(int n, long[] distance, long[] cost) {
        int ps = 0;
        long answer = 0;
        for (int i = 1; i < cost.length; i++) {
            if(cost[i] < cost[ps]){
                answer += cost[ps] * (distance[i] - distance[ps]);
                ps = i;
            }
        }
        if(ps != n - 1){
            answer += cost[ps] * (distance[n - 1] - distance[ps]);
        }
        System.out.println(answer);
    }

}
