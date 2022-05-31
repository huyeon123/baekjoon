package queue;

import java.util.*;
import java.io.*;

public class 요세푸스문제0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        LinkedList<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.println(sb);
    }
}
