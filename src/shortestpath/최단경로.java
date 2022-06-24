package shortestpath;

import java.util.*;
import java.io.*;

public class 최단경로 {

    static HashMap<Integer, List<Edge>> graph = new HashMap<>();
    static int[] cost;
    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        cost = new int[v + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        int start = Integer.parseInt(br.readLine());

        for (int i = 1; i <= v; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, weight));
        }

        solution(start);
    }

    private static void solution(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            if (cost[current.to] < current.weight) continue;

            List<Edge> edges = graph.get(current.to);
            for (Edge edge : edges) {
                int candidate = cost[current.to] + edge.weight;
                if (candidate < cost[edge.to]) {
                    cost[edge.to] = candidate;
                    queue.add(new Edge(edge.to, candidate));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cost.length; i++) {
            if (cost[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(cost[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


}
