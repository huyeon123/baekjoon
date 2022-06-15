package dp.dp2;

import java.util.*;
import java.io.*;

public class 내리막길 {
    static int n, m;
    static int[][] map, dp;
    //우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1; //끝에 도달하면 한개 누적
        }

        if (dp[x][y] == -1) { //한번도 가지 않은 곳만 탐색
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!(newX < 0 || newX >= n || newY < 0 || newY >= m)) {
                    if (map[x][y] > map[newX][newY]) {
                        dp[x][y] += dfs(newX, newY);
                    }
                }
            }
        }

        return dp[x][y];
    }
}
