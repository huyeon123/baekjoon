package binarysearch;

import java.util.*;
import java.io.*;

public class 수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int ls = 0, rs = n - 1;
            boolean find = false;
            while (ls <= rs){
                int mid = (ls + rs) / 2;
                if (target > A[mid]){
                    ls = mid + 1;
                } else if (target < A[mid]) {
                    rs = mid - 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.println(sb);
    }


}
