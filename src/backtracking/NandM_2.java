package backtracking;

import java.util.Scanner;

public class NandM_2 {
    static int n, m;
    static int[] combination;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];
        check = new boolean[n + 1];
        solution(0, 1);
    }

    public static void solution(int level, int start) {
        if(level == m){
            for (int i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                if(!check[i]){
                    check[i] = true;
                    combination[level] = i;
                    solution(level + 1, i);
                    check[i] = false;
                }
            }
        }
    }

}
