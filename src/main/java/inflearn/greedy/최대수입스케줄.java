package inflearn.greedy;

import java.util.*;

/**
 * https://cote.inflearn.com/contest/10/problem/09-04
 * 최대 수입 스케쥴(PriorityQueue 응용문제)
 *
 * 가장 많이 남은 일자(max) 기준으로 정렬 후,
 * 데이터 순회하면서 max보다 작은 날짜가 아닌 경우 금액을 우선순위에 넣고
 * 순회하다가 max보다 작은 날짜를 만난 경우
 * 일자를 감소하면서 가장 비싼 강의를 우선순위 큐에서 꺼내온다.
 */
public class 최대수입스케줄 {
    public static void main(String[] args) {
        final 최대수입스케줄 test = new 최대수입스케줄();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] seminars = new int[n][2];

        for (int i = 0; i < n; i++) {
            seminars[i][0] = s.nextInt();
            seminars[i][1] = s.nextInt();
        }

        System.out.println(test.solution(n, seminars));
    }

    private int solution(final int n, final int[][] datas) {
        List<Seminar> seminars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seminars.add(new Seminar(datas[i][0], datas[i][1]));
        }
        Collections.sort(seminars);

        int money = 0;
        int maxDuration = getMaxDuration(datas);
        PriorityQueue<Integer> moneys = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for (int duration = maxDuration; duration > 0; duration--) {
            for (; i < n; i++) {
                Seminar seminar = seminars.get(i);
                if (seminar.isLessThanTime(duration)) {
                    break;
                }
                moneys.offer(seminar.getMoney());
            }
            if (!moneys.isEmpty()) {
                money += moneys.poll();
            }
        }

        return money;
    }

    private int getMaxDuration(final int[][] datas) {
        int max = 0;
        for (int i = 0; i < datas.length; i++) {
            if (max < datas[i][1]) {
                max = datas[i][1];
            }
        }
        return max;
    }
}

class Seminar implements Comparable<Seminar> {

    private int money;
    private int duration;

    public int getMoney() {
        return money;
    }

    public boolean isLessThanTime(int duration) {
        return this.duration < duration;
    }

    public Seminar(final int money, final int duration) {
        this.money = money;
        this.duration = duration;
    }

    @Override
    public int compareTo(final Seminar o) {
        return Integer.compare(o.duration, this.duration);
    }
}

