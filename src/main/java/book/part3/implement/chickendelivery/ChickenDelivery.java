package book.part3.implement.chickendelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 치킨 배달
 * 1. 치킨집 좌표와 집 좌표들을 분리해서 보관한다.
 * 2. 폐업될 M개의 치킨집 중 가장 작은 도시의 치킨 거리를 구해야 하기 때문에 조합으로 M개의 치킨집들을 구한다.
 * 3. 조합의 수만큼 반복하여 집 기준으로 조합에서 구한 치킨집과의 가장 작은 거리를 구하고 그 값이 치킨 거리가 된다.
 * 4. 해당 조합의 치킨 거리들을 더해주어 도시의 치킨 거리를 구한다.
 * 5. 조합의 수만큼 반복하여 도시의 치킨 거리가 가장 작은 수를 구한다.
 *
 * 해당 문제는 순열, 조합을 할 수 있는지 묻는 문제 같다.
 * n과m을 풀어봐서 다행이다.
 */
public class ChickenDelivery {
    private static final List<Position> houses = new ArrayList<>();
    private static final List<Position> chickens = new ArrayList<>();
    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        final int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int data = scanner.nextInt();
                map[i][j] = data;
                if (isHouse(data)) {
                    houses.add(new Position(i, j));
                }

                if (isChicken(data)) {
                    chickens.add(new Position(i, j));
                }
            }
        }
        System.out.println(calculateDistance(m));
    }

    private static boolean isHouse(final int data) {
        return data == HOUSE;
    }

    private static boolean isChicken(final int data) {
        return data == CHICKEN;
    }

    private static int calculateDistance(final int m) {
        List<List<Position>> permutations = getPermutations(m);
        int result = Integer.MAX_VALUE;

        // 순열의 수 만큼 반복
        for (List<Position> combination : permutations) {
            int chickenDistanceOfCity = 0;

            for (Position house : houses) {
                int chickenDistance = Integer.MAX_VALUE;
                // 현재 집과 가장 가까운 치킨집 찾기
                for (int i = 0; i < m; i++) {
                    final Position chicken = combination.get(i);
                    final int distance = house.getDiff(chicken);
                    chickenDistance = Math.min(chickenDistance, distance);
                }
                chickenDistanceOfCity += chickenDistance;
            }
            result = Math.min(result, chickenDistanceOfCity);
        }
        return result;
    }

    private static List<List<Position>> getPermutations(final int m) {
        Permutation permutation = new Permutation(chickens, m);
        permutation.permute(0, 0);
        return permutation.getResult();
    }
}
