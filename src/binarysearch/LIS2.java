package binarysearch;

import java.util.*;
import java.io.*;

public class LIS2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int length = 1;

        for (int i = 1; i < n; i++) {
            int key = arr[i];

            if (lis[length - 1] < key) { //추가
                length++;
                lis[length - 1] = key;
            } else { //대치
                int ls = 0, rs = length;

                while (ls < rs) {
                    int mid = (ls + rs) / 2;

                    if (lis[mid] < key) {
                        ls = mid + 1;
                    } else {
                        rs = mid;
                    }
                }

                lis[ls] = key;
            }
        }
        System.out.println(length);
    }
}
