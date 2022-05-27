package greedy;

import java.util.*;
import java.io.*;

public class 동전0 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        solution(coin, n, k);
    }

    public static void solution(int[] coin, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (coin[i] <= k) {
                int count = k / coin[i];
                k -= coin[i] * count;
                answer += count;
            }
        }
        System.out.println(answer);
    }
}
