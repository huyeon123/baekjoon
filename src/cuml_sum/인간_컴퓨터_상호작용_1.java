package cuml_sum;

import java.util.*;
import java.io.*;

public class 인간_컴퓨터_상호작용_1 {

    static HashMap<Character, List<Integer>> table = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("case.txt")), 16_777_216);
        long beforeTime = System.currentTimeMillis();
        String S = br.readLine();
        for (int i = 0; i < S.toCharArray().length; i++) {
            char c = S.charAt(i);
            if(table.containsKey(c)) table.get(c).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                table.put(c, list);
            }
        }

        int q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Character alphabet = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(table.containsKey(alphabet)) solution(alphabet, l , r);
            else System.out.println(0);
        }
        long afterTime = System.currentTimeMillis();
        System.out.println("최종 시간 : " + (afterTime - beforeTime) / 1000);

    }

    public static void solution(Character alphabet, int l, int r) {
        List<Integer> list = table.get(alphabet);
        System.out.println(count(list, r, true) - count(list, l, false));
    }

    private static int count(List<Integer> list, int target, boolean include){
        int count = 0;
        if(include){
            for (Integer integer : list) {
                if (integer > target) break;
                count++;
            }
        } else {
            for (Integer integer : list) {
                if (integer >= target) break;
                count++;
            }
        }
        return count;
    }

}
