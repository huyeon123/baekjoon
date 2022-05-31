package queue;

import java.util.*;
import java.io.*;

public class 카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1){
            queue.poll();
            if(queue.size() != 1) queue.add(queue.poll());
            else break;
        }

        System.out.println(queue.poll());
    }

}
