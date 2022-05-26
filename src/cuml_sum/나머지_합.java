package cuml_sum;

import java.util.*;
import java.io.*;

public class 나머지_합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] count = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % m;
            count[sum]++;
        }

        /* (sum[j] - sum[i]) % m = 0 에서
        * sum[j] % m = sum[i] % m 이므로
        * m의 나머지 중 2개 (i와 j)를 선택하면된다.
        */
        long ans = count[0]; //sum[i] % m == 0인 경우 혼자만 존재해도 가능
        for (int i = 0; i < m; i++) {
            ans += (long) count[i] * (count[i] - 1) / 2; // nCr에서 r = 2 인 것을 공식으로 계산
        }
        System.out.println(ans);
    }

}
