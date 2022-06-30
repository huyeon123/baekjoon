package shortestpath;

import java.util.*;
import java.io.*;

public class 타임머신 {

    static ArrayList<Route> graph = new ArrayList<>();
    static long[] dist;
    static int n, m;
    static final long INF = 30_000_000_000L; // Edge 수 X MAX_COST X Vertex 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Route(a, b, c));
        }

        if (!solution(1)) {
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == INF) sb.append(-1);
                else sb.append(dist[i]);
                sb.append("\n");
            }
            System.out.println(sb);
        } else System.out.println("-1");
    }

    private static boolean solution(int start) {
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            for (Route route : graph) {
                if (dist[route.from] != INF && dist[route.to] > dist[route.from] + route.weight) {
                    dist[route.to] = dist[route.from] + route.weight;
                    if (i == n - 1) { //n - 1번째에도 갱신이 된다면 음수순환이 존재함을 의미
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Route {
        int from;
        int to;
        int weight;

        public Route(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

}
