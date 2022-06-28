package shortestpath;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {

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

            //0-1 BFS에서 최단거리를 찾기 위해서는 가중치가 낮은 경로를 우선순위로 두어야함
            if (before * 2 <= 100000 && check[before * 2] == 0) {
                check[before * 2] = check[before];
                queue.add(before * 2);
            }
            if (before - 1 >= 0 && check[before - 1] == 0) {
                check[before - 1] = check[before] + 1;
                queue.add(before - 1);
            }
            if (before + 1 <= 100000 && check[before + 1] == 0) {
                check[before + 1] = check[before] + 1;
                queue.add(before + 1);
            }
        }
    }

}
