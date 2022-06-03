package divideandconquer;

import java.util.*;
import java.io.*;

public class 이항계수3 {

    static final long p = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long numerator = fact(n);
        long denominator = fact(k) * fact(n - k) % p;

        System.out.println(numerator * solution(denominator, p - 2) % p);
    }

    public static long fact(long num) {
        long result = 1L;

        for (long l = num; l > 0; l--) result = (result * l) % p;

        return result;
    }

    public static long solution(long a, long b) {
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % p;
            a = (a * a) % p;
            b /= 2;
        }
        return result;
    }

}
