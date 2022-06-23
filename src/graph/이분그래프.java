package graph;

import java.util.*;
import java.io.*;

public class 이분그래프 {

    static ArrayList<Integer>[] graph;
    static int[] visit;
    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < k; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList[v + 1];
            visit = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                graph[to].add(from);
            }
            solution();
        }
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (visit[i] == 0) {
                queue.add(i);
                visit[i] = 1;
            }

            while (!queue.isEmpty()) {
                Integer current = queue.poll();

                for (int j = 0; j < graph[current].size(); j++) {
                    Integer next = graph[current].get(j);
                    if(visit[next] == 0) queue.add(next);

                    if (visit[next] == visit[current]) {
                        System.out.println("NO");
                        return;
                    }

                    if (visit[next] == 0) {
                        if(visit[current] == 1) visit[next] = 2;
                        else if(visit[current] == 2) visit[next] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
