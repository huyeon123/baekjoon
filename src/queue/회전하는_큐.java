package queue;

import java.util.*;
import java.io.*;

public class 회전하는_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] target = new int[m];

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        solution(deque, target, m);
    }

    public static void solution(LinkedList<Integer> deque, int[] target, int m) {
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int index = deque.indexOf(target[i]);
            if (index == 0) deque.poll();
            else {
                if(deque.size() - index - 1 < index){ //third op
                    while (!deque.isEmpty()) {
                        Integer checkNum = deque.pollLast();
                        answer++;
                        if(checkNum == target[i]) break;
                        deque.addFirst(checkNum);
                    }
                } else { //second op
                    while (!deque.isEmpty()) {
                        Integer checkNum = deque.poll();
                        if(checkNum == target[i]) break;
                        answer++;
                        deque.add(checkNum);
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
