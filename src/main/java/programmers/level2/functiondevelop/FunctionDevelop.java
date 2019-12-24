package programmers.level2.functiondevelop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelop extends Solution {

    private static final int COMPLETE_RATE = 100;

    @Override
    public int[] solution(final int[] progresses, final int[] speeds) {
        return progress(progresses, speeds);
    }

    private int[] progress(final int[] progresses, final int[] speeds) {
        Queue<ProgressRate> rates = initProgressRates(progresses, speeds);
        List<Integer> actual = new ArrayList<>();
        int completeCount = 0;

        //진행율 큐가 비워질때까지 반복
        while (!rates.isEmpty()) {
            completeCount = checkCompleteRate(rates);
            if (completeCount > 0) {
                for (int i=0; i<completeCount; i++) {
                    rates.poll();
                }
                actual.add(completeCount);
            }
            // 진행율 상승
            rates.stream().forEach(ProgressRate::up);
        }

        return actual.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    // 진행율 큐 생성
    private Queue<ProgressRate> initProgressRates(final int[] progresses, final int[] speeds) {
        Queue<ProgressRate> rates = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            rates.offer(new ProgressRate(progresses[i], speeds[i]));
        }
        return rates;
    }

    // 완료된 진행율 체크
    private int checkCompleteRate(final Queue<ProgressRate> rates) {
        int count = 0;
        for (ProgressRate progressRate : rates) {
            if (progressRate.getRate() < COMPLETE_RATE) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
