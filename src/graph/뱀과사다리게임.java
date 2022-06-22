package graph;

import java.util.*;
import java.io.*;

public class 뱀과사다리게임 {

    static int[] board = new int[101], ladderAndSnake = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 101; i++) {
            ladderAndSnake[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            ladderAndSnake[idx] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            ladderAndSnake[idx] = Integer.parseInt(st.nextToken());
        }

        solution(1);
        System.out.println(board[100]);
    }

    public static void solution(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            Integer idx = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int newX = idx + i;
                if (newX == 100) {
                    board[newX] = board[idx] + 1;
                    return;
                }
                if (newX <= 100 && board[ladderAndSnake[newX]] == 0) {
                    queue.add(ladderAndSnake[newX]);
                    board[ladderAndSnake[newX]] = board[idx] + 1;
                }
            }
        }
    }

}
