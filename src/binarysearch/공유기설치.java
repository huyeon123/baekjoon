package binarysearch;

import java.util.*;
import java.io.*;

public class 공유기설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        solution(x, c);
    }

    public static void solution(int[] x, int c) {
        int ls = 1, rs = x[x.length - 1] - x[0] + 1;
        int mid;
        while (ls < rs){
            mid = (ls + rs) / 2;
            if(install(x, mid) >= c){
                ls = mid + 1;
            } else {
                rs = mid;
            }
        }
        System.out.println(ls - 1);
    }

    private static int install(int[] x, int mid) {
        int count = 1;
        int before = x[0];

        for (int i = 1; i < x.length; i++) {
            if(x[i] - before >= mid){
                count++;
                before = x[i];
            }
        }

        return count;
    }


}
