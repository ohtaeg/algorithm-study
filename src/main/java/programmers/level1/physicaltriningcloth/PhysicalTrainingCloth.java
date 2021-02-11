package programmers.level1.physicaltriningcloth;

import java.util.HashSet;
import java.util.Set;

public class PhysicalTrainingCloth {
    private static final int ZERO = 0;

    public int solution(int n, int[] losts, int[] reserves) {
        int answer = n - losts.length;
        Set<Integer> remains = new HashSet<>();

        for (int reserve : reserves) {
            remains.add(reserve);
        }

        for (int i = 0; i < losts.length; i++) {
            int lost = losts[i];
            if (remains.contains(lost)) {
                remains.remove(lost);
                losts[i] = ZERO;
                answer++;
            }
        }

        for (int lost : losts) {
            if (lost == ZERO) {
                continue;
            }

            if (remains.contains(lost - 1)) {
                remains.remove(lost - 1);
                answer++;
            } else if (remains.contains(lost + 1)) {
                remains.remove(lost + 1);
                answer++;
            }
        }

        return answer;
    }
}
