package queue;

import java.util.*;
import java.io.*;

public class 큐2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        LinkedList<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();
            switch (op) {
                case "push":
                    queue.add(Integer.valueOf(st.nextToken()));
                    continue;
                case "pop":
                    if (queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.poll());
                    break;
                case "size":
                    sb.append(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append("1");
                    else sb.append("0");
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.getFirst());
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.getLast());
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
