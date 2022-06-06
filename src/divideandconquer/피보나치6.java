package divideandconquer;

import java.io.*;

public class 피보나치6 {

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n < 2) System.out.println(n);
        else solution(n);
    }

    public static void solution(long n) {
        long[][] A = {{1, 1}, {1, 0}};
        long[][] result = {{1, 0}, {0, 1}};
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, A);
            }
            A = multiply(A, A);
            n /= 2;
        }

        System.out.println(result[0][1]);
    }

    public static long[][] multiply(long[][] A, long[][] B) {
        int size = A.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += (A[i][k] * B[k][j]) % mod;
                    result[i][j] %= mod;
                }
            }
        }
        return result;
    }

}
