package dp.dp1;

import java.util.*;
import java.io.*;

public class 정수_삼각형 {

    static int line = 1; // 0번째 줄부터 시작이나, 0번째 줄은 이전 줄이 없으므로 1부터 시작
    static int before;  // 배열을 하나만 쓰기 위해 이전 값을 저장해둘 필요가 있음(앞 원소에서 값을 덮어씌우기 때문)
    static int[] dp; // 각 인덱스의 값이 최대가 되도록 누적하는 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int countTokens = st.countTokens(); // nextToken()을 사용할때마다 개수가 줄어드므로 변하지 않도록 변수 저장
            for (int j = 0; j < countTokens; j++) {
                solution(j, Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    public static void solution(int index, int value) {
        if (index == 0) { // 첫 번째 원소는 이전 줄 첫 번째 원소와만 합칠 수 있음
            before = dp[index]; // 다음 원소에서 사용할 수 있도록 덮어쓰기 전에 저장
            dp[index] += value;
        } else if (index == line) { // 라인 수는 마지막 원소 인덱스를 의미
            dp[index] = before + value; // 이전 값(dp[index - 1])에 값 누적
            line++; // 다음 라인
        } else { // 중간에 있는 원소는 이전 줄 dp[index - 1]과 dp[index] 중 최대값 선택 후 누적
            //함수의 파라미터는 앞쪽부터 우선순위를 가짐
            //넘어가기 전에 대입 연산자(=)가 실행되므로
            //앞은 누적되기 전 dp[index - 1]의 값이 들어가고, 뒤는 누적되기 전 dp[index]값으로 들어감
            //그와 동시에 다음 원소에서 사용할 수 있도록 dp[index]값이 before 에 저장
            dp[index] = Math.max(before, before = dp[index]) + value;
            //만약 누적 이후에 대입연산자를 사용했다면 before 에 이미 누적된 값이 들어가므로 올바르지 않음
            //max 이전에 대입연산자를 사용했다면, 이전 dp[index-1]값이 없어지므로 올바르지 않음
        }
    }

}
