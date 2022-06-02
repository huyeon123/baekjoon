package divideandconquer;

import java.util.*;
import java.io.*;

public class 쿼드트리 {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] lineChars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = lineChars[j] - 48;
            }
        }

        solution(n, 0, 0);
        System.out.println(sb);
    }

    public static void solution(int size, int rowStart, int colStart) {
        int sum = 0;
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == 0) {
            sb.append(0);
        } else if (sum == size * size) {
            sb.append(1);
        } else {
            sb.append("(");
            solution(size / 2, rowStart, colStart);
            solution(size / 2, rowStart, colStart + size / 2);
            solution(size / 2, rowStart + size / 2, colStart);
            solution(size / 2, rowStart + size / 2, colStart + size / 2);
            sb.append(")");
        }
    }

}
