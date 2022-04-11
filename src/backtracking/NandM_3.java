package backtracking;

import java.util.*;

public class NandM_3 {
    static int n, m;
    static int[] combination;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];
        solution(0);
        System.out.println(sb.toString());
    }

    public static void solution(int level) {
        if(level == m){
            for (int i : combination) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                combination[level] = i;
                solution(level + 1);
            }
        }
    }

}
