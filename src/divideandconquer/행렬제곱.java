package divideandconquer;

import java.util.*;
import java.io.*;

public class 행렬제곱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = solution(A, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] solution(int[][] arr, long exp) {
        if(exp == 1) return arr;

        int[][] temp = solution(arr, exp / 2);
        int[][] result = multiply(temp, temp); //제곱

        if(exp % 2 == 1) return multiply(result, arr); // exp가 홀수면 한번 더 곱하기
        return result;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int size = A.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

}
