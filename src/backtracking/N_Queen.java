package backtracking;

import java.util.*;
import java.io.*;

public class N_Queen {

    static int n;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        solution(0);

        System.out.println(answer);
    }

    public static void solution(int row) {
        if(row == n) answer++;
        else {
            for (int i = 0; i < n; i++) {
                arr[row] = i;
                if(possible(row)){
                    solution(row + 1);
                }
            }
        }
    }

    private static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if(arr[row] == arr[i]) return false;
            else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }

}
