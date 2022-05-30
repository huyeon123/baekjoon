package stack;

import java.util.*;
import java.io.*;

public class 스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = 0, i = 1;
        while (idx < n) {
            if(stack.isEmpty() || target[idx] >= i) {
                stack.push(i++);
                sb.append("+\n");
                continue;
            }

            if(stack.peek() == target[idx]){
                stack.pop();
                sb.append("-\n");
                idx++;
                continue;
            }

            if(target[idx] < i && stack.peek() != target[idx]){
                System.out.println("NO");
                return;
            }
        }
        sb.append("-\n".repeat(stack.size()));
        System.out.println(sb);
    }
}
