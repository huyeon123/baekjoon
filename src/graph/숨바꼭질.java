package graph;

import java.util.*;
import java.io.*;

public class 숨바꼭질 {

    static int[] check = new int[100000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n, k);
        System.out.println(check[k]);
    }

    private static void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        check[n] = 1;
        while (!queue.isEmpty()) {
            int before = queue.poll();

            if (before == k) {
                check[k] = check[before] - 1;
                return;
            }

            if (before - 1 >= 0 && check[before - 1] == 0) {
                check[before - 1] = check[before] + 1;
                queue.add(before - 1);
            }
            if (before + 1 <= 100000 && check[before + 1] == 0) {
                check[before + 1] = check[before] + 1;
                queue.add(before + 1);
            }
            if (before * 2 <= 100000 && check[before * 2] == 0) {
                check[before * 2] = check[before] + 1;
                queue.add(before * 2);
            }
        }
    }
}
