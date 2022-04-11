package backtracking;

import java.util.*;
import java.io.*;

public class 스타트와링크 {

    static int n, diff, answer = Integer.MAX_VALUE;
    static int[][] S;
    static int[] combinationStart, combinationLink;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        combinationStart = new int[n / 2];
        combinationLink = new int[n / 2];
        S = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
        System.out.println(answer);
    }

    public static void solution(int level, int next) {
        if (level == n / 2) {
            int startIdx = 0, linkIdx = 0, start = 0, link = 0;
            for (int i = 0; i < n; i++) {
                if(startIdx >= n / 2 || combinationStart[startIdx] != i) {
                    combinationLink[linkIdx++] = i;
                } else startIdx++;
            }
            for (int i = 0; i < combinationStart.length; i++) {
                for (int j = i + 1; j < combinationStart.length; j++) {
                    start += S[combinationStart[i]][combinationStart[j]];
                    start += S[combinationStart[j]][combinationStart[i]];
                }
            }
            for (int i = 0; i < combinationLink.length; i++) {
                for (int j = i + 1; j < combinationLink.length; j++) {
                    link += S[combinationLink[i]][combinationLink[j]];
                    link += S[combinationLink[j]][combinationLink[i]];
                }
            }
            diff = Math.abs(start - link);
            answer = Math.min(answer, diff);
        } else {
            for (int i = next; i < n; i++) {
                combinationStart[level] = i;
                solution(level + 1, i + 1);
            }
        }
    }

}
