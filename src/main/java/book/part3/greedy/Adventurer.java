package book.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 모험가 길드
 */
public class Adventurer {
    // TODO : 답이 더 간단하게 풀림, 다시 풀때 최적화를 생각해볼 것
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] source = bufferedReader.readLine()
                                        .split(" ");

        int result = group(source);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int group(final String[] source) {
        final int[] adventurers = convertArray(source);
        int groupResult = 0;
        int degreeOfFear;
        for (int i = 0; i < adventurers.length; i += degreeOfFear) {
            degreeOfFear = adventurers[i];
            if (isPossibleGroup(adventurers, degreeOfFear, i)) {
                groupResult++;
            }
        }
        return groupResult;
    }

    private static boolean isPossibleGroup(final int[] adventurers, final int degreeOfFear, final int index) {
        for (int i = index; i < index + degreeOfFear; i++) {
            if (degreeOfFear < adventurers[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] convertArray(final String[] source) {
        return Arrays.stream(source)
                     .mapToInt(Integer::parseInt)
                     .sorted()
                     .toArray();
    }
}
