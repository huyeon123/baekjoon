package divideandconquer;

import java.util.*;
import java.io.*;

public class 색종이 {

    static int white, blue;
    static int[][] initArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        initArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                initArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n, 0, 0);
        System.out.println(white + "\n" + blue);
    }

    public static void solution(int size, int rowStart, int colStart) {
        int sum = 0;
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                sum += initArr[i][j];
            }
        }
        if (sum == 0) {
            white++;
        } else if (sum == size * size) {
            blue++;
        } else {
            solution(size / 2, rowStart, colStart);
            solution(size / 2, rowStart, colStart + size / 2);
            solution(size / 2, rowStart + size / 2, colStart);
            solution(size / 2, rowStart + size / 2, colStart + size / 2);
        }
    }


}
