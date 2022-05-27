package greedy;

import java.util.*;
import java.io.*;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = arr[0];
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1];
            answer += arr[i];
        }
        System.out.println(answer);
    }

    public static void solution() {

    }

}
