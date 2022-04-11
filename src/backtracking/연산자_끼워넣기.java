package backtracking;

import java.util.*;
import java.io.*;

public class 연산자_끼워넣기 {

    static int n;
    static int[] arr;
    static int[] operand = new int[4];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operand[i] = Integer.parseInt(st.nextToken());

        solution(0, arr[0]);
        System.out.print(max + "\n" + min);
    }

    public static void solution(int idx, int prev) {
        if (idx == n - 1) {
            min = Math.min(min, prev);
            max = Math.max(max, prev);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operand[i] != 0) {
                    int temp = prev;
                    switch (i) {
                        case 0:
                            prev += arr[idx + 1];
                            break;
                        case 1:
                            prev -= arr[idx + 1];
                            break;
                        case 2:
                            prev *= arr[idx + 1];
                            break;
                        case 3:
                            if (arr[idx + 1] < 0){
                                arr[idx + 1] *= -1;
                                prev /= arr[idx + 1];
                                prev *= -1;
                            } else prev /= arr[idx + 1];
                            break;
                    }
                    operand[i]--;
                    solution(idx + 1, prev);
                    operand[i]++;
                    prev = temp;
                }
            }
        }
    }

}
