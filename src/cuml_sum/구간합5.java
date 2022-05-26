package cuml_sum;

import java.util.*;
import java.io.*;

public class 구간합5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            solution(arr, x1, y1, x2, y2);
        }

    }

    public static void solution(int[][] arr, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = y1; i <= y2; i++) {
            sum += arr[x2][i] - arr[x1 - 1][i];
        }
        System.out.println(sum);
    }

}
