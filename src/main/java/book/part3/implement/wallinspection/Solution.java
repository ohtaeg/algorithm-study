package book.part3.implement.wallinspection;

import java.util.List;

/**
 * 외벽 점검 - 문제를 잘 이해 못해서 답을 보고 이해함 다시 풀어볼 것
 * 1. 투입해야하는 친구의 모든 경우수를 구한다.
 * 2. 취약한 지점이 원형으로 되어 있어서 일직선으로 확장한다.
 * 3. 첫번째 weak 부터 투입한 거리를 더해 검사할 수 있는지 판단한다.
 *  3.1 만약 거리가 안되면 다음 친구를 투입하고 투입한 친구 카운트 증가
 *  3.2 만약 거리가 된다면 다음 weak로 넘어간다.
 * 4. 첫번째 weak 기준으로 원형을 돌았다면 다음 weak를 기준으로 잡고 원형을 돈다. 즉 다음 weak 기준으로 3번을 다시 수행
 */
public class Solution {
    private static int[] spreadWeaknesses;

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int n = 12;
        final int[] weak = {1, 5, 6, 10};
        final int[] dist = {1, 2, 3, 4};

        final int[] weak1 = {1, 3, 4, 9, 10};
        final int[] dist1 = {3, 5, 7};
        System.out.println(solution.solution(n, weak, dist));
        System.out.println(solution.solution(n, weak1, dist1));
    }

    public int solution(int n, int[] weak, int[] dist) {
        int answer = dist.length + 1;
        this.spreadWeaknesses = spreadCircle(weak, n);
        List<List<Integer>> friendsPermutation = getPermutation(dist);

        for (int startWeakIndex = 0; startWeakIndex < weak.length; startWeakIndex++) {
            for (List<Integer> friends : friendsPermutation) {
                int friendInputCount = 1;
                int maxMovablePosition = spreadWeaknesses[startWeakIndex] + friends.get(friendInputCount - 1);
                int index = startWeakIndex;
                while (index < startWeakIndex + weak.length) {
                    // 만약 점검할 거리가 안된다면 현재 위치에서 다음 친구 투입후, 다음 친구가 최대로 갈 수 있는 위치 계산
                    if (maxMovablePosition < spreadWeaknesses[index]) {
                        friendInputCount++;
                        // 해당 수열은 끝 다음 수열로 가기위해 반복문 종료
                        if (friendInputCount > dist.length) {
                            break;
                        }
                        maxMovablePosition = spreadWeaknesses[index] + friends.get(friendInputCount - 1);
                    } else {
                        // 투입한 친구가 검사할 거리가 된다면 다음 weak로 이동
                        index++;
                    }
                }
                answer = Math.min(answer, friendInputCount);
            }
        }

        if (answer > dist.length) {
            return -1;
        }

        return answer;
    }

    private List<List<Integer>> getPermutation(final int[] dist) {
        Permutation permutation = new Permutation(dist.length);
        permutation.permute(dist, 0);
        return permutation.getResult();
    }

    private int[] spreadCircle(final int[] weak, final int n) {
        final int length = weak.length;
        final int[] weaknesses = new int[length * 2];
        for (int i = 0; i < length * 2 - 1; i++) {
            if (i >= length) {
                weaknesses[i] = weak[i % length] + n;
            } else {
                weaknesses[i] = weak[i];
            }
        }
        return weaknesses;
    }
}
