package queue;

import java.util.*;
import java.io.*;

public class 덱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        LinkedList<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "push_front":
                    deque.addFirst(Integer.valueOf(st.nextToken()));
                    continue;
                case "push_back":
                    deque.add(Integer.valueOf(st.nextToken()));
                    continue;
                case "pop_front":
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.poll());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.pollLast());
                    break;
                case "size":
                    sb.append(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append("1");
                    else sb.append("0");
                    break;
                case "front":
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.getFirst());
                    break;
                case "back":
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.getLast());
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
