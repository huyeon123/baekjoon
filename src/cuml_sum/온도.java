package cuml_sum;

import java.util.*;
import java.io.*;

public class 온도 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(k == 1) System.out.println(Arrays.stream(arr).max().getAsInt());
        else solution(arr, k);
    }

    public static void solution(int[] arr, int k) {
        int max = 0, sum;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }

        sum = max;

        for (int i = 1; i <= arr.length - k; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
