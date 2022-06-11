package priortyqueue;

import java.util.*;
import java.io.*;

public class MaxHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll());
                } else sb.append("0");
                sb.append("\n");
            }
            pq.add(value);
        }
        System.out.println(sb);
    }
}
