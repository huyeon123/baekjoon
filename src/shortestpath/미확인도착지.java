package shortestpath;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class 미확인도착지 {

    static int n, m, t, s, g, h;
    static int[] cost;
    static int[][] graph;
    static final int INF = 50_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            graph = new int[n + 1][n + 1];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n; i++) {
                Arrays.fill(graph[i], INF);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                //가중치를 2배 해주면 모두 짝수가 됨
                graph[a][b] = graph[b][a] = 2 * c;
            }

            //g - h 도로만 1을 빼서 홀수로 만들어줌 (해당 도로가 포함되면 비용은 반드시 홀수)
            graph[g][h] = graph[h][g] = graph[g][h] - 1;

            List<Integer> X = new ArrayList<>();
            for (int i = 0; i < t; i++) X.add(Integer.parseInt(br.readLine()));
            X.sort(Comparator.naturalOrder());

            int[] possible = new int[n + 1];
            //최단 경로가 g - h 도로를 포함하고 있는가?
            for (Integer x : X) {
                possible[x] = traversal(s, x);
            }

            for (int i = 0; i < possible.length; i++) {
                if ((possible[i] & 1) == 1) sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static int traversal(int start, int end) {
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

                for (int i = 1; i <= n; i++) {
                    if (!check[i] && cost[current] + graph[current][i] < cost[i]) {
                        cost[i] = cost[current] + graph[current][i];
                        queue.add(new Edge(i, cost[i]));
                    }
                }
            }
        }
        return cost[end];
    }

    static class Edge implements Comparable<Edge> {
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
