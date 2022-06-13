package dp.dp1;

import java.util.*;
import java.io.*;

public class 피보나치 {

    static int t;
    static int[] dpZero, dpOne, testCase;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        testCase = new int[t];
        for (int i = 0; i < t; i++) testCase[i] = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num = testCase[i];
            if (num >= 2) {
                dpZero = new int[num + 1];
                dpOne = new int[num + 1];
                dpZero[0] = dpOne[1] = 1;
                dpZero[1] = dpOne[0] = 0;
                solution(num);
            } else if (num == 0) {
                System.out.println("1 0");
            } else if (num == 1) {
                System.out.println("0 1");
            }
        }
    }

    public static void solution(int target) {
        for (int i = 2; i <= target; i++) {
            dpZero[i] = dpZero[i - 1] + dpZero[i - 2];
            dpOne[i] = dpOne[i - 1] + dpOne[i - 2];
        }
        System.out.println(dpZero[target] + " " + dpOne[target]);
    }

}
