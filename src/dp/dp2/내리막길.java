package dp.dp2;

import java.util.*;
import java.io.*;

public class 내리막길 {
    //우, 하, 좌, 상
    static int[] x = {0, 1, 0, -1};
    static int[] y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Coordinate> backTrack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] check = new boolean[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        int X = 0, Y = 0, idx = 0;
        while (true) {
            boolean inside = true;
            for (int i = 0; i < 4; i++) {
                if (i == 0 && idx != 0) {
                    if(idx < 4){
                        i = idx;
                        idx = 0;
                    } else X = Integer.MAX_VALUE;
                }
                int newX = X + x[i];
                int newY = Y + y[i];
                if (!(newX >= n || newX < 0 || newY >= m || newY < 0)) {
                    if (map[X][Y] > map[newX][newY]) {
                        backTrack.add(new Coordinate(X, Y, i + 1));
                        check[newX][newY] = !check[newX][newY];
                        dp[newX][newY]++;
                        X = newX;
                        Y = newY;
                        break;
                    }
                }
                if (i == 3) {
                    check[X][Y] = !check[X][Y];
                    if(!backTrack.isEmpty()){
                        Coordinate cd = backTrack.pop();
                        X = cd.x;
                        Y = cd.y;
                        idx = cd.i;
                    } else inside = false;
                }
            }
            if(!inside && X == 0 && Y == 0) break;
        }
        System.out.println(dp[n - 1][m - 1]);
    }

    static class Coordinate {
        int x, y, i;

        public Coordinate(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

}
