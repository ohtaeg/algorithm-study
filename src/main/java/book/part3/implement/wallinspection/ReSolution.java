package book.part3.implement.wallinspection;

import java.util.List;

/**
 * 외벽 점검 재풀이
 * 논리는 이전과 동일.
 * 다만 저번에는 직선을 일직선으로 펼쳤다면 이번엔 펼치지 않고 이차원 배열로 다룸
 */
public class ReSolution {
    public static void main(String[] args) {
        ReSolution reSolution = new ReSolution();
        final int n = 12;
        final int[] weak = {1, 5, 6, 10};
        final int[] dist = {1, 2, 3, 4};

        final int[] weak1 = {1, 3, 4, 9, 10};
        final int[] dist1 = {3, 5, 7};
        System.out.println(reSolution.solution(n, weak, dist));
        System.out.println(reSolution.solution(n, weak1, dist1));
    }

    public int solution(int n, int[] weak, int[] dist) {
        int[][] weaknesses = spreadWeak(n, weak);
        List<List<Integer>> friendCases = permute(dist);

        int answer = inspectWall(weaknesses, friendCases, dist);

        if (answer > dist.length) {
            answer = -1;
        }
        return answer;
    }

    private int[][] spreadWeak(final int n, final int[] weak) {
        final int length = weak.length;
        int[][] weaknesses = new int[length][length];

        for (int i = 0; i < length; i++) {
            int[] rotate = new int[length];
            for (int j = 0; j < length; j++) {
                if (j + i >= length) {
                    rotate[j] = weak[(j + i) % length] + n;
                } else {
                    rotate[j] = weak[j + i];
                }
                weaknesses[i] = rotate;
            }
        }

        return weaknesses;
    }

    private List<List<Integer>> permute(final int[] dist) {
        Permutation permutation = new Permutation(dist.length);
        permutation.permute(dist, 0);
        return permutation.getResult();
    }

    private int inspectWall(final int[][] weaknesses, final List<List<Integer>> friendCases, final int[] dist) {
        int min = dist.length + 1;

        for (int[] weak : weaknesses) {
            for (List<Integer> friends : friendCases) {
                int weakIndex = 0;
                int friendInputCount = 1;
                int movablePosition = weak[weakIndex] + friends.get(friendInputCount - 1);

                while (weakIndex < weak.length) {
                    if (movablePosition < weak[weakIndex]) {
                        friendInputCount++;
                        if (friendInputCount > dist.length) {
                            break;
                        }
                        movablePosition = weak[weakIndex] + friends.get(friendInputCount - 1);
                    } else {
                        weakIndex++;
                    }
                }

                min = Math.min(min, friendInputCount);
            }
        }
        return min;
    }
}
