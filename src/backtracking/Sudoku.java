package backtracking;

import java.util.*;
import java.io.*;

public class Sudoku {

    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
    }

    public static void solution(int row, int column) {
        if (column == 9) {
            solution(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (arr[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                arr[row][column] = i;
                if (possible(row, column)) {
                    solution(row, column + 1);
                }
            }
            arr[row][column] = 0;
            return;
        }

        solution(row, column + 1);
    }

    private static boolean possible(int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (arr[i][column] == arr[row][column]) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == column) continue;
            if (arr[row][i] == arr[row][column]) return false;
        }

        int rowRange = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int colRange = (column / 3) * 3; // value가 속한 3x3의 열의 첫 위치

        for (int i = rowRange; i < rowRange + 3; i++) {
            for (int j = colRange; j < colRange + 3; j++) {
                if (i == row && j == column) continue;
                if (arr[i][j] == arr[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
}
