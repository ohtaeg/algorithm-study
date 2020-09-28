package book.part3.sort.failrate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailRate {
    public static void main(String[] args) {
        int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result2 = solution(4, new int[]{4, 4, 4, 4, 4});
        int[] result3 = solution(8, new int[]{1, 2, 3, 4, 5, 6, 7});
        print(result);
        print(result2);
        print(result3);
    }

    public static int[] solution(final int N, int[] stages) {
        int[] counts = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            counts[stages[i]] += 1;
        }

        List<Stage> stageList = new ArrayList<>();
        int length = stages.length;
        for (int i = 0; i < N; i++) {
            int stage = i + 1;
            int stay = counts[stage];
            if (stay == 0 || length == 0) {
                stageList.add(new Stage(stage, 0));
            } else {
                stageList.add(new Stage(stage, (double) stay / length));
                length -= stay;
            }
        }

        Collections.sort(stageList);
        return stageList.stream()
                        .mapToInt(Stage::getStageIndex)
                        .limit(N)
                        .toArray();
    }

    private static void print(final int[] result) {
        System.out.print("[");
        for (int stage : result) {
            System.out.print(stage + " ");
        }
        System.out.println("]");
        System.out.println();
    }
}

