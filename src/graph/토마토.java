package graph;

import java.util.*;
import java.io.*;

public class 토마토 {

    static Queue<int[]> queue = new LinkedList<>();
    static int[][] field;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, answer = -1, count = 0, tomato = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        field = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] != -1) {
                    tomato++;
                    if(field[i][j] == 1){
                        count++;
                        queue.add(new int[]{i, j});
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
                for (int j = 0; j < 4; j++) {
                    int newX = coordinate[0] + dx[j];
                    int newY = coordinate[1] + dy[j];
                    if (!(newX < 0 | newX >= n | newY < 0 | newY >= m)
                            && field[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY});
                        count++;
                        field[newX][newY] = field[coordinate[0]][coordinate[1]] + 1;
                    }
                }
            }
            answer++;
        }
        if(tomato == count) System.out.println(answer);
        else System.out.println("-1");
    }

}
