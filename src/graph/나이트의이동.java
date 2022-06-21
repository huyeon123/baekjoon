package graph;

import java.util.*;
import java.io.*;

public class 나이트의이동 {

    static Queue<int[]> queue = new LinkedList<>();
    static int[][] chess;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int l, targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new int[]{x, y});
            chess[x][y] = 1;

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            if (x == targetX && y == targetY) {
                sb.append("0").append("\n");
            } else {
                solution();
                sb.append(chess[targetX][targetY]).append("\n");
                queue.clear();
            }
        }
        System.out.println(sb);
    }

    private static void solution() {
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = coordinate[0] + dx[i];
                int newY = coordinate[1] + dy[i];

                if (newX == targetX && newY == targetY) {
                    chess[targetX][targetY] = chess[coordinate[0]][coordinate[1]];
                    return;
                }

                if (!(newX < 0 | newY < 0 | newX >= l | newY >= l)
                        && chess[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    chess[newX][newY] = chess[coordinate[0]][coordinate[1]] + 1;
                }
            }
        }
    }

}
