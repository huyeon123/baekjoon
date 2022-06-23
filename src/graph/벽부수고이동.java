package graph;

import java.util.*;
import java.io.*;

public class 벽부수고이동 {

    static int[][][] visit;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[2][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line, j, j + 1, 10);
            }
        }

        solution(new Coordinate(0, 0, true));

        int resultByNotThrough = visit[0][n - 1][m - 1];
        int resultByTrough = visit[1][n - 1][m - 1];

        if (resultByNotThrough == 0 && resultByTrough == 0) System.out.println("-1");
        else {
            if (resultByTrough == 0) System.out.println(resultByNotThrough);
            else System.out.println(resultByTrough);
        }
    }

    public static void solution(Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(coordinate);
        visit[0][coordinate.x][coordinate.y] = 1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                int through = current.canThrough ? 0 : 1;

                if (newX == n - 1 && newY == m - 1) {
                    visit[through][newX][newY] = visit[through][current.x][current.y] + 1;
                    return;
                }

                if(newX < 0 || newX >= n || newY < 0 || newY >= m || visit[through][newX][newY] != 0) continue;
                if (map[newX][newY] == 1) { //벽
                    if (current.canThrough) { //벽 부실수 있음
                        queue.add(new Coordinate(newX, newY, false));
                        visit[1][newX][newY] = visit[0][current.x][current.y] + 1;
                    }
                } else { //벽이 아님
                    queue.add(new Coordinate(newX, newY, current.canThrough));
                    visit[through][newX][newY] = visit[through][current.x][current.y] + 1;
                }
            }
        }
    }

    static class Coordinate {
        int x, y;
        boolean canThrough;

        public Coordinate(int x, int y, boolean canThrough) {
            this.x = x;
            this.y = y;
            this.canThrough = canThrough;
        }
    }


}
