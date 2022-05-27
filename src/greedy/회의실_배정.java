package greedy;

import java.util.*;
import java.io.*;

public class 회의실_배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        solution(list);
    }

    public static void solution(ArrayList<Time> list) {
        int answer = 0, beforeTime = 0;
        for (Time time : list) {
            if(time.start >= beforeTime){
                answer++;
                beforeTime = time.end;
            }
        }
        System.out.println(answer);
    }

    static class Time implements Comparable<Time>{
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

}
