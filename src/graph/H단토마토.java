package graph;

import java.util.*;
import java.io.*;

public class H단토마토 {

    static Queue<int[]> queue = new LinkedList<>();
    static int[][][] box;
    static int[] dx = {0, 0, 0, 0, -1, 1}; //위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int n, m, h, answer = -1, count = 0, tomato = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                    if(box[z][x][y] != -1) {
                        tomato++;
                        if(box[z][x][y] == 1){
                            count++;
                            queue.add(new int[]{z, x, y});
                        }
                    }
                }
            }
        }

        if(queue.isEmpty()) {
            System.out.println("-1");
            return;
        }
        solution();
    }

    private static void solution() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int newZ = coordinate[0] + dz[j];
                    int newX = coordinate[1] + dx[j];
                    int newY = coordinate[2] + dy[j];
                    if (!(newX < 0 | newX >= n | newY < 0 | newY >= m | newZ < 0 | newZ >= h)
                            && box[newZ][newX][newY] == 0) {
                        queue.add(new int[]{newZ, newX, newY});
                        count++;
                        box[newZ][newX][newY] = 1;
                    }
                }
            }
            answer++;
        }
        if(tomato == count) System.out.println(answer);
        else System.out.println("-1");
    }

}
