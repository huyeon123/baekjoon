package cuml_sum;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class 인간_컴퓨터_상호작용_2 {

    static final int ALPHABET_COUNT = 26;
    static int[][] table;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        table = new int[S.length()][ALPHABET_COUNT];
        char[] arr = S.toCharArray();

        for (int i = 0; i < arr.length; i++) { //S.toCharArray().length로 하면 계속 배열로 변환시켜서 시간 오래걸림
            int c = arr[i] - 97;
            if(i != 0){ //System.arrayCopy() 쓰면 오래걸림(어노테이션-리플렉션 때문인 듯)
                for (int j = 0; j < ALPHABET_COUNT; j++) {
                    table[i][j] = table[i - 1][j];
                }
            }
            table[i][c]++;
        }

        int q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int alphabet = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (l > 0) sb.append(table[r][alphabet] - table[l - 1][alphabet]).append('\n');
            else sb.append(table[r][alphabet]).append('\n');
        }
        System.out.println(sb);
    }

    public static String generateCase() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 200000;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        buffer.append("\n");
        buffer.append("200000\n");
        for (int i = 0; i < 200000; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt).append(" ");
            int first = random.nextInt(200000);
            int second = random.nextInt(200000);
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            buffer.append(first).append(" ").append(second).append("\n");
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);
        return generatedString;
    }
}
