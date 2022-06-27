package shortestpath;

import java.util.*;
import java.io.*;

public class 특정최단경로 {

    static HashMap<Integer, List<Edge>> graph = new HashMap<>();
    static int[] cost;
    static int n, e;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int waypoint1 = Integer.parseInt(st.nextToken());
        int waypoint2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += solution(1, waypoint1);
        answer1 += solution(waypoint1, waypoint2);
        answer1 += solution(waypoint2, n);

        int answer2 = 0;
        answer2 += solution(1, waypoint2);
        answer2 += solution(waypoint2, waypoint1);
        answer2 += solution(waypoint1, n);

        int answer = (answer1 >= INF && answer2 >= INF) ? -1 : Math.min(answer1, answer2);
        System.out.println(answer);
    }

    private static int solution(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        cost = new int[n + 1];
        Arrays.fill(cost, INF);
        boolean[] check = new boolean[n + 1];

        queue.add(new Edge(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int current = e.to;

            if (!check[current]) {
                check[current] = true;

                List<Edge> edges = graph.get(current);
                for (Edge edge : edges) {
                    int candidate = cost[current] + edge.weight;
                    if (!check[edge.to] && candidate < cost[edge.to]) {
                        cost[edge.to] = candidate;
                        queue.add(new Edge(edge.to, candidate));
                    }
                }
            }
        }
        return cost[end];
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
