package backtracking;

import java.util.*;
import java.io.*;

public class NandM_4 {

    static int n, m;
    static int[] combination;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combination = new int[m];

        solution(0, 1);

        System.out.println(sb.toString());
    }

    public static void solution(int level, int start) {
        if(level == m){
            for (int i : combination) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = start; i <= n; i++) {
                combination[level] = i;
                solution(level + 1, i);
            }
        }
    }

}
