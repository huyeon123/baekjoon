package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder("[");
            LinkedList<Integer> ac = new LinkedList<>();
            char[] func = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());

            String num = br.readLine();
            num = num.substring(1, num.length() - 1);
            StringTokenizer st = new StringTokenizer(num, ",");

            for (int j = 0; j < size; j++) {
                ac.add(Integer.parseInt(st.nextToken()));
            }

            boolean error = false, reverse = false;
            for (char c : func) {
                if (c == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if (c == 'D') {
                    if (ac.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    } else {
                        if (reverse) ac.pollLast();
                        else ac.poll();
                    }
                }
            }

            if (reverse) Collections.reverse(ac); //안하고 거꾸로 읽는게 좋음.

            if (!error) {
                for (Integer integer : ac) {
                    sb.append(integer).append(",");
                }
                if(ac.isEmpty()) System.out.println("[]");
                else {
                    sb.deleteCharAt(sb.length() - 1).append("]");
                    System.out.println(sb);
                }
            }
        }
    }
}
