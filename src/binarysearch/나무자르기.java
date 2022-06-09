package binarysearch;

import java.util.*;
import java.io.*;

public class 나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] wood = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
            if (max < wood[i]) max = wood[i];
        }

        solution(wood, max, m);
    }

    public static void solution(int[] wood, int rs, int target) {
        int ls = 0, mid = 0;
        while (ls <= rs) {
            long sum = 0;
            mid = (ls + rs) / 2;

            for (int i : wood) {
                int length = i - mid;
                if(length > 0) sum += length;
            }

            if(sum >= target){
                ls = mid + 1;
            } else {
                rs = mid;
            }
        }
        System.out.println(ls - 1);
    }

}
