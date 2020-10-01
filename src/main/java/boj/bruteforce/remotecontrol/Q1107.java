package boj.bruteforce.remotecontrol;

import java.util.Scanner;

/**
 * 리모컨
 * 수학적으로 차이를 최소화 하는 방식으로 구하면 반례가 많음
 * 1555
 * 8
 * 0 1 3 4 5 6 7 9, 즉 2, 8만 버튼을 누를 수 있을때
 * 수학적으로 1개의 버튼 마다 최소 차이를 구분한다면
 * 1과 최소 차이인 버튼 2
 * 5와 최소 차이인 버튼 2
 * 5와 최소 차이인 버튼 2
 * 5와 최소 차이인 버튼 2
 * 2222 - 1555 = 667 + 4 = 671번 횟수가 눌린다.
 * <p>
 * 최소차이가 아닌 방법으로 한다면 888
 * 1555 - 888 = 667 + 3 = 670
 */
public class Q1107 {
    private static final int MAX = 1000000;
    private static final int CURRENT_CHANNEL = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int target = scanner.nextInt();
        final int m = scanner.nextInt();
        final boolean[] brokenRemoteControl = new boolean[10];

        for (int i = 0; i < m; i++) {
            brokenRemoteControl[scanner.nextInt()] = true;
        }

        RemoteControl remoteControl = new RemoteControl(brokenRemoteControl);
        int result = pushButton(remoteControl, target);
        System.out.println(result);
    }

    private static int pushButton(final RemoteControl remoteControl, final int target) {
        final int plusMinusButtonPushCount = abs(target - CURRENT_CHANNEL);
        int min = plusMinusButtonPushCount;

        for (int number = 0; number < MAX; number++) {
            int pushCount;
            if (remoteControl.canPushButton(number)) {
                // 숫자 버튼을 누른 횟수 + 이동하려는 채널과의 차이(++ or -- 횟수)
                pushCount = remoteControl.calculatePushCount(number) + abs(target - number);
            } else {
                pushCount = plusMinusButtonPushCount;
            }
            min = Integer.min(min, pushCount);
        }

        return min;
    }

    private static int abs(final int number) {
        return Math.abs(number);
    }
}

