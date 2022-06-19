package graph;

import java.util.*;
import java.io.*;

public class 유기농배추 {

    static int[][] filed;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, k, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            filed = new int[n][m];
            check = new boolean[n][m];

            int answer = 0;

            for (int cabbage = 0; cabbage < k; cabbage++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                filed[x][y] = 1;
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (!check[row][col]) {
                        solution(row, col);
                        if(count != 0){
                            answer++;
                            count = 0;
                        }
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void solution(int row, int col) {
        if(filed[row][col] == 0) return;

        check[row][col] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int newX = row + dx[i];
            int newY = col + dy[i];
            if (!(newX < 0 | newX >= n | newY < 0 | newY >= m)
                    && !check[newX][newY]) solution(newX, newY);
        }
    }

}
