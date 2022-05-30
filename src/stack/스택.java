package stack;

import java.util.*;
import java.io.*;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();

            if (op.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            if (op.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else System.out.println(stack.pop());
            }

            if (op.equals("size")) System.out.println(stack.size());

            if (op.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }

            if (op.equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}
