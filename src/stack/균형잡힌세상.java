package stack;

import java.util.*;
import java.io.*;

public class 균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            char[] charArray = str.toCharArray();
            boolean balance = true;

            for (char c : charArray) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    else {
                        balance = false;
                        break;
                    }
                }

                if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        balance = false;
                        break;
                    }
                }
            }
            if(balance && stack.isEmpty()) sb.append("yes\n");
            else {
                sb.append("no\n");
                stack.clear();
            }
        }
        System.out.println(sb);
    }
}
