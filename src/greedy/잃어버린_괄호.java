package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        solution(str);
    }

    public static void solution(String str) {
        String[] splitToMinus = str.split("-");
        int answer = 0; boolean first = true;
        for (String exp : splitToMinus) {
            int sum = 0;
            String[] splitToPlus = exp.split("\\+");
            for (String num : splitToPlus) {
                sum += Integer.parseInt(num);
            }
            if(first) {
                answer += sum;
                first = false;
            }
            else answer -= sum;
        }
        System.out.println(answer);
    }

}
