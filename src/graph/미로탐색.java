package graph;

import java.util.*;
import java.io.*;

public class 미로탐색 {

    static int[][] maze;
    static boolean[][] check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(token[j]);
            }
        }

        solution(0, 0);
        System.out.println(maze[n - 1][m - 1]);
    }

    private static void solution(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = coordinate[0] + dx[i];
                int newY = coordinate[1] + dy[i];
                if (!(newX < 0 | newX >= n | newY < 0 | newY >= m)
                        && !check[newX][newY]
                        && maze[newX][newY] != 0) {
                    queue.add(new int[]{newX, newY});
                    check[newX][newY] = true;
                    maze[newX][newY] = maze[coordinate[0]][coordinate[1]] + 1;
                }
            }
        }
    }
}
