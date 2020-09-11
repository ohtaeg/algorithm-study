package book.part2.greedy;

import java.io.*;
import java.util.Arrays;

/**
 * 큰 수의 법칙
 * 주어진 수들을 M번 더하여 가장 큰수를 만들어라
 * 특정 인덱스의 수가 연속해서 K번을 초과하여 더해질 수 없다.
 * 예로 2 4 5 4 6이 주어지고 M = 8, K = 3일때
 * 6 6 6 5 6 6 6 5 = 46이 가장 큰수가 된다.
 *
 * 3 4 3 4 3이 주어지고 M = 7, K = 2일때
 * 4 4 4 4 4 4 4 = 28이 된다.
 * 배열크기 N, 더해지는 횟수 M, K가 첫째줄에 주어지고 데이터는 둘째줄에 주어진다.
 * 입력예시
 * 5 8 3
 * 2 4 5 4 6
 * 출력
 * 46
 */
public class TheLawOfGreatNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] source = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(source[1]);
        int k = Integer.parseInt(source[2]);
        int[] data = convertIntArray(bufferedReader.readLine().split(" "));

        int result1 = add(m, k, data); // 내풀이
        int result2 = add2(m, k, data); // 동빈나 풀이

        bufferedWriter.write(String.valueOf(result1));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(result2));
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[] convertIntArray(final String[] data) {
        return Arrays.stream(data)
                     .mapToInt(Integer::parseInt)
                     .sorted()
                     .toArray();
    }

    private static int add(int m, final int k, final int[] data) {
        int result = 0;
        int addCount = 0;
        int max = data[data.length - 1];
        int nextMax = data[data.length - 2];

        while (m-- > 0) {
            if (addCount == k) {
                result += nextMax;
                addCount = 0;
                continue;
            }
            result += max;
            addCount++;
        }

        return result;
    }

    /**
     * 만약 M의 크기가 100억이라면 반복문으로 풀이한다면 시간초과가 발생하게된다. 수학적으로 접근하여 풀 수 있다.
     * 1. 먼저 반복되는 수열에 대해 파악한다.
     * M이 8이고 K가 3일때는 6 6 6 5   6 6 6 5가 일정하게 반복되는데 반복되는 수열의 길이는 K + 1이 된다.
     * M을 k + 1로 나눈 몫이 수열이 반복되는 횟수가 되며, 수열이 반복되는 횟수 * K를 곱하면 가장 큰수가 등장하는 횟수가 된다.
     * M / (K + 1) * K
     * M이 (K + 1)로 딱 나눠떨어지지 않을 수도 있다. M = 8, k = 4일때 66665 666이 되기 때문에 나머지만큼 더해줘야 한다.
     * M / (K + 1) * K + (M % (K + 1))
     * @param m
     * @param k
     * @param data
     * @return
     */
    private static int add2(final int m, final int k, final int[] data) {
        int addMaxCount = (m / (k + 1)) * k + (m % (k + 1));
        int max = data[data.length - 1];
        int nextMax = data[data.length - 2];
        return addMaxCount * max + (m - addMaxCount) * nextMax;
    }
}
