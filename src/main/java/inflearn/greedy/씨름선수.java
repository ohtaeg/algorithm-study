package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73412
 * 이중 포문을 돌면 time limit MAX 30,000, O(N^2)
 *
 * 객체를 생성하여 키에 대해 선정렬 O(N)
 * 그리디란 현재 시점에 최선의 선택을 해서 나아가는 것, 미래는 신경쓰지 않는다.
 */
public class 씨름선수 {

    public static void main(String[] args) {
        final 씨름선수 test = new 씨름선수();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] applicants = new int[n][2];

        for (int i = 0; i < n; i++) {
            applicants[i][0] = s.nextInt();
            applicants[i][1] = s.nextInt();
        }

        System.out.println(test.solution(n, applicants));
    }

    public int solution(int n, int[][] applicants) {
        List<Body> bodies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bodies.add(new Body(applicants[i][0], applicants[i][1]));
        }

        Collections.sort(bodies);

        int count = 0;
        int maxWeight = 0;

        for (Body body : bodies) {
            if (body.weight > maxWeight) {
                maxWeight = body.weight;
                count++;
            }
        }

        return count;
    }

}

class Body implements Comparable{
    int height;
    int weight;

    public Body(final int height, final int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(final Object o) {
        Body other = (Body) o;
        return Integer.compare(other.height, this.height);
    }
}
