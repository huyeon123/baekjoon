package queue;

import java.util.*;
import java.io.*;

public class 프린터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNum; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            while (!queue.isEmpty()) {
                boolean print = true;
                Integer target = queue.poll();
                for (Integer integer : queue) {
                    if(integer > target){
                        queue.add(target);
                        print = false;
                        break;
                    }
                }

                if(print){
                    count++;
                    if(m == 0){
                        sb.append(count).append("\n");
                        break;
                    }
                }

                m = m - 1 < 0 ? queue.size() - 1 : m - 1;
            }
        }
        System.out.println(sb);
    }

}
