package binarysearch;

import java.io.*;

public class k번째수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int ls = 1, rs = k;
        while (ls < rs) {
            int mid = (ls + rs) / 2;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += Math.min(mid / i, n); //몫이 n보다 커지는 것을 방지
            }
            if (sum >= k) {
                rs = mid;
            } else {
                ls = mid + 1;
            }
        }
        System.out.println(ls);
    }


    /*
    * 초기에 짠 코드 -> 배열 초기화 과정에서 OutOfMemory, O(n)이라 빠르긴함
    * static int count = 0;
    private static void search(int[][] arr, int n, int k) {
        int startRow = 0, startCol = 0;
        boolean find = false;

        for (int i = 1; i <= n; i++) {
            if (count + i > k) {
                startCol = i - 1;
                find = true;
                break;
            }
            count += i;
        }
        if (!find) {
            for (int i = n - 1; i > 0; i--) {
                if (count + i > k) {
                    startRow = n - i;
                    startCol = n - 1;
                    break;
                }
                count += i;
            }
        }
        lineSearch(startRow, startCol, k, arr);
    }

    private static void lineSearch(int startRow, int startCol, int k, int[][] arr) {
        boolean up = true;
        while (true) {
            count++;
            if (count == k) break;
            int temp;
            if (up) {
                temp = startRow;
                startRow = startCol;
            } else {
                temp = startRow - 1;
                startRow = startCol + 1;
            }
            startCol = temp;
            up = !up;
        }
        System.out.println(arr[startRow][startCol]);
    }
    */
}
