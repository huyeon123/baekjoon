package binarysearch;

import java.util.*;
import java.io.*;
import java.util.function.Predicate;

public class 숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(bound(arr, target, false) - bound(arr, target, true)).append(" ");
        }

        System.out.println(sb);
    }

    public static int bound(int[] arr, int target, boolean lower) {
        int ls = 0, rs = arr.length;

        while (ls < rs) {
            int mid = (ls + rs) / 2;

            if (lower) {
                if (target <= arr[mid]) rs = mid;
                else ls = mid + 1;
            } else {
                if (target < arr[mid]) rs = mid;
                else ls = mid + 1;
            }

        }
        return ls;
    }
}
