package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/09-02
 *
 * 최대 사용할 수 있는 회의의 갯수를 구하기 위해서는
 * 1. 끝시간이 가장 빠른 것부터 오름차순 정렬 후 시작시간이 가장 빠른 오름 차순 정렬을 해준다.
 * 2. 회의가 빨리 끝나는 것부터 회의를 진행시킨다.
 * 3. 끝나는 회의의 끝나는 시간이 다음 회의의 시작시간보다 같거나 크면 해당 회의를 진행시킨다.
 */
public class 회의실배정 {
    public static void main(String[] args) {
        final 회의실배정 test = new 회의실배정();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = s.nextInt();
            meetings[i][1] = s.nextInt();
        }

        System.out.println(test.solution(n, meetings));
    }

    private int solution(final int n, final int[][] times) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(times[i][0], times[i][1]));
        }
        Collections.sort(meetings);

        int count = 0;
        int currentEndTime = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= currentEndTime) {
                count++;
                currentEndTime = meeting.end;
            }
        }

        return count;
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(final Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
