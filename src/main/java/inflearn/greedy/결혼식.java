package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/09-03
 * 정렬을 하고 현재 머물고 있는 상태인지 카운팅을 하는 방법으로 진행
 * 만약 떠났다면 다시 -1 해주고 최대값을 구하는 것이기 때문에 카운팅 값이 max값 보다 높은지도 비교
 */
public class 결혼식 {

    public static final char EXIST = 's';
    public static final char LEAVE = 'e';

    public static void main(String[] args) {
        final 결혼식 test = new 결혼식();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = s.nextInt();
            times[i][1] = s.nextInt();
        }

        System.out.println(test.solution(n, times));
    }

    private int solution(final int n, final int[][] datas) {
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(datas[i][0], EXIST));
            times.add(new Time(datas[i][1], LEAVE));
        }
        Collections.sort(times);

        int answer = 0;
        int count = 0;

        for (Time time : times) {
            if (time.isExist()) {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}

class Time implements Comparable<Time> {
    int time;
    char state;

    public Time(final int time, final char state) {
        this.time = time;
        this.state = state;
    }

    public boolean isExist() {
        return this.state == 결혼식.EXIST;
    }

    @Override
    public int compareTo(final Time o) {
        if (this.time == o.time) {
            return this.state - o.state;
        }
        return this.time - o.time;
    }
}
