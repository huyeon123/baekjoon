package graph;

import java.util.*;
import java.io.*;

public class 바이러스 {

    static HashMap<Integer, List<Integer>> network = new HashMap<>();
    static int answer = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        check[1] = true;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            List<Integer> values = network.getOrDefault(v1, new ArrayList<>());
            values.add(v2);
            network.put(v1, values);

            values = network.getOrDefault(v2, new ArrayList<>());
            values.add(v1);
            network.put(v2, values);
        }

        solution(1);
        System.out.println(answer);
    }

    public static void solution(int vertex) {
        List<Integer> list = network.get(vertex);
        if(list == null) return;

        for (Integer integer : list) {
            if (!check[integer]) {
                answer++;
                check[integer] = true;
                solution(integer);
            }
        }
    }

}
