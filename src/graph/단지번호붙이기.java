package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 단지번호붙이기 {

    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> cluster = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(token[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    solution(i, j);
                    if (count != 0) {
                        cluster.add(count);
                        count = 0;
                    }
                }
            }
        }
        solution(0, 0);

        cluster.sort(Comparator.naturalOrder());
        sb.append(cluster.size()).append("\n");
        for (Integer integer : cluster) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }

    public static void solution(int row, int col) {
        if (map[row][col] == 0) return;

        check[row][col] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int newX = row + dx[i];
            int newY = col + dy[i];
            if (!(newX < 0 | newX >= map.length | newY < 0 | newY >= map.length)
                    && !check[newX][newY]) solution(newX, newY);
        }
    }

}
