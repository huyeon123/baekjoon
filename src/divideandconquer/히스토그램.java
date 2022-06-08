package divideandconquer;

import java.util.*;
import java.io.*;

public class 히스토그램 {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            sb.append(solution(0, n - 1)).append("\n");
        }

        System.out.println(sb);
    }

    public static long solution(int start, int end) {
        if(start == end) return arr[start];

        int mid = (start + end) / 2;

        long leftArea = solution(start, mid);
        long rightArea = solution(mid + 1, end);

        long maxSpace = Math.max(leftArea, rightArea);

        return Math.max(maxSpace, getMaxSpace(start, mid, end));
    }

    public static long getMaxSpace(int start, int mid, int end) {
        int lp = mid;
        int rp = mid;

        long height = arr[mid];

        long maxSpace = height;

        // 양 끝 범위를 벗어나기 전까지 반복
        while(start < lp && rp < end) {
            if(arr[lp - 1] < arr[rp + 1]) {
                rp++;
                height = Math.min(height, arr[rp]);
            } else {
                lp--;
                height = Math.min(height, arr[lp]);
            }

            maxSpace = Math.max(maxSpace, height * (rp - lp + 1));
        }

        // 오른쪽 구간을 끝까지 탐색 못했다면 마저 탐색
        while(rp < end) {
            rp++;
            height = Math.min(height, arr[rp]);
            maxSpace = Math.max(maxSpace, height * (rp - lp + 1));
        }

        // 왼쪽 구간을 끝까지 탐색 못했다면 마저 탐색
        while(start < lp) {
            lp--;
            height = Math.min(height, arr[lp]);
            maxSpace = Math.max(maxSpace, height * (rp - lp + 1));
        }

        return maxSpace;
    }

}
