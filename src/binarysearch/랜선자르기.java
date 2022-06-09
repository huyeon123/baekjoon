package binarysearch;

import java.util.*;
import java.io.*;

public class 랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lan = new int[k];
        long max = 0; //(2^31 - 1) + 1 해서 오버플로우나는 것을 방지하기 위해 long으로 지정

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        solution(max + 1, lan, n); //max + 1은 mid가 0이되는 것을 방지
    }

    public static void solution(long rs, int[] lan, int target) {
        long ls = 0;
        long mid = 0;
        while (ls < rs) {
            mid = (ls + rs) / 2;
            long count = 0;
            for (int i : lan) {
                count += (i / mid);
            }
            if (count >= target) {
                ls = mid + 1;
            } else {
                rs = mid;
            }
        }
        System.out.println(ls - 1); //upperBound를 찾았기 때문에 1을 내림
    }

}
