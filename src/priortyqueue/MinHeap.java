package priortyqueue;

import java.util.*;
import java.io.*;

public class MinHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll());
                } else sb.append("0");
                sb.append("\n");
                continue;
            }
            pq.add(value);
        }
        System.out.println(sb);
    }

}
