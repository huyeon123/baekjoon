package graph;

import java.util.*;
import java.io.*;

public class DFSandBFS {

    static HashMap<Integer, LinkedList<Integer>> table = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        check = new boolean[n + 1];
        check[v] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            LinkedList<Integer> values = table.getOrDefault(v1, new LinkedList<>());
            values.add(v2);
            table.put(v1, values);

            values = table.getOrDefault(v2, new LinkedList<>());
            values.add(v1);
            table.put(v2, values);
        }

        sb.append(v).append(" ");
        dfs(v);
        System.out.println(sb);

        sb = new StringBuilder();
        check = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int vertex) {
        LinkedList<Integer> queue = table.get(vertex);
        if(queue == null) return;

        Collections.sort(queue);
        for (Integer integer : queue) {
            if (!check[integer]) {
                sb.append(integer).append(" ");
                check[integer] = true;
                dfs(integer);
            }
        }

    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            if (!check[key]) {
                sb.append(key).append(" ");
                check[key] = true;
                if(table.get(key) != null) queue.addAll(table.get(key));
            }
        }
    }

}
