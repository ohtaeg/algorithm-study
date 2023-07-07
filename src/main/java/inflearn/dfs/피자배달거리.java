package inflearn.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problems
 *
 * 전체 피잣집 갯수 증 M개를 뽑아야하므로 조합을 이용한다.
 * 조합으로 선택된 피자들을 구하고 집마다 피자 배달거리를 구하고 최소값을 누적하여 도시의 피자 배달거리를 구한다.
 * 각 조합 경우의 수만큼 도시의 피자 배달 거리의 최소 값을 비교한다.
 */
public class 피자배달거리 {
    private static int n, m;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> pizzas = new ArrayList<>();
    private static int[] combi;
    private static int 최소도시피자배달거리 = Integer.MAX_VALUE;

    private void dfs(final int level, final int number) {
        if (level == m) {
            // 각 집의 피자 배달 거리 구하기
            int 집의피자배달거리합 = 0;
            for (Point house : houses) {
                int distance = Integer.MAX_VALUE;
                for (int i : combi) {
                    final Point pizza = pizzas.get(i);
                    distance = Math.min(distance, Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y));
                }
                집의피자배달거리합 += distance;
            }
            최소도시피자배달거리 = Math.min(최소도시피자배달거리, 집의피자배달거리합);
            return;
        }

        for (int i = number; i < pizzas.size(); i++) {
            combi[level] = i;
            dfs(level + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        피자배달거리 main = new 피자배달거리();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    houses.add(new Point(i, j));
                } else if (x == 2) {
                    pizzas.add(new Point(i, j));
                }
            }
        }

        combi = new int[m];
        main.dfs(0, 0);
        System.out.println(최소도시피자배달거리);
    }

    private static class Point {
        public int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
