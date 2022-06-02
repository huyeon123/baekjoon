package divideandconquer;

import java.util.*;
import java.io.*;

public class 종이의개수 {

    static int zero, pos, neg;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n, 0, 0);
        System.out.println(neg + "\n" + zero + "\n" + pos);
    }

    public static void solution(int size, int rowStart, int colStart) {
        int type = arr[rowStart][colStart]; //첫번째 원소를 type으로 지정

        //type과 다른숫자가 있다면 분할 수행
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if(type != arr[i][j]){
                    type = -2;
                    break;
                }
            }
        }
        if (type == 0) zero++;
        else if (type == 1) pos++;
        else if (type == -1) neg++;
        else {
            //첫번째 행
            solution(size / 3, rowStart, colStart);
            solution(size / 3, rowStart, colStart + size / 3);
            solution(size / 3, rowStart, colStart + 2 * (size / 3));

            //두번째 행
            solution(size / 3, rowStart + size / 3, colStart);
            solution(size / 3, rowStart + size / 3 , colStart + size / 3);
            solution(size / 3, rowStart + size / 3 , colStart + 2 * (size / 3));

            //세번째 행
            solution(size / 3, rowStart + 2 * (size / 3), colStart);
            solution(size / 3, rowStart + 2 * (size / 3), colStart + size / 3);
            solution(size / 3, rowStart + 2 * (size / 3), colStart + 2 * (size / 3));
        }
    }

}
