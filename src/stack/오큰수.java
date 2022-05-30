package stack;

import java.util.*;
import java.io.*;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); //인덱스를 저장

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){ //top이 가리키는 인덱스의 값이 arr[i]보다 작을경우
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) arr[stack.pop()] = -1; //오큰수가 없는 숫자들은 -1로 변경

        for (int i = 0; i < n; i++) sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }

}
