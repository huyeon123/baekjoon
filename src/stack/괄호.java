package stack;

import java.util.*;
import java.io.*;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            boolean vps = true;

            for (char c : charArray) {
                if (c == '(') {
                    stack.push(0);
                    continue;
                }

                if (stack.isEmpty()) {
                    vps = false;
                    break;
                } else stack.pop();
            }
            if (vps && stack.isEmpty()) sb.append("YES\n");
            else {
                sb.append("NO\n");
                stack.clear();
            }
        }
        System.out.println(sb);
    }


}
