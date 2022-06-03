package divideandconquer;

import java.util.*;
import java.io.*;

public class 곱셈 {

    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(solution(a, b));
    }

    public static long solution(long a, long b) {
        if(b == 1) return a % c;

        long temp = solution(a, b / 2);

        if(b % 2 == 1) return (temp * temp % c) * a % c;
        else return temp * temp % c;
    }
}
