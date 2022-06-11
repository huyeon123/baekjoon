package priortyqueue;

import java.util.*;
import java.io.*;

public class AbsHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int compare = Integer.compare(Math.abs(o1), Math.abs(o2));
            if(compare == 0) return o1; //o1이 음수이면 뒤로가고, 양수이면 앞으로감
            return compare;
        });
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
