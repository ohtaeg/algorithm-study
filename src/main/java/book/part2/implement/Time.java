package book.part2.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시각
 * 00시 00분 00초부터 N시 59분 59초까지의 시간중 3이 포함된 경우의수를 구하시오
 * 5 -> 11475
 * 데이터 갯수가 100만개 이하라면 완전 탐색(브루트포스)를 이용해도 적절하다.
 */
public class Time {
    private static final String THREE = "3";
    private static final int TIME_LIMIT = 60;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bufferedReader.readLine());

        int count = 0;
        for (int hour = 0; hour <= n; hour++) {
            for (int minute = 0; minute < TIME_LIMIT; minute++) {
                for (int second = 0; second < TIME_LIMIT; second++) {
                    if (isContainThree(hour, minute, second)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        bufferedReader.close();
    }

    private static boolean isContainThree(final int hour, final int minute, final int second) {
        return isContainThree(hour) || isContainThree(minute) || isContainThree(second);
    }

    private static boolean isContainThree(final int number) {
        return String.valueOf(number).contains(THREE);
    }
}
