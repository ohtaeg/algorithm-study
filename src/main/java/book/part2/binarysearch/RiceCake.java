package book.part2.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RiceCake {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] source = bufferedReader.readLine().split(" ");
        final int m = Integer.parseInt(source[1]);
        String[] riceCakes = bufferedReader.readLine().split(" ");

        System.out.println(getMaxHeight(riceCakes, m));
        bufferedReader.close();
    }

    private static int getMaxHeight(final String[] array, final int m) {
        final int[] riceCakes = convertIntegerArray(array);

        return searchBinary(riceCakes, m, 0, riceCakes[riceCakes.length - 1]);
    }

    private static int searchBinary(final int[] riceCakes, final int target, int start, int end) {
        while (start <= end) {
            int sum = 0;
            int height = (start + end) / 2;
            for (int riceCake : riceCakes) {
                sum += riceCake - height  < 0 ? 0 : riceCake - height;
            }

            if (sum == target) {
                return sum;
            }

            if (sum > target) {
                start = height + 1;
            } else {
                end = height - 1;
            }
        }

        return -1;
    }

    private static int[] convertIntegerArray(final String[] array) {
        return Arrays.stream(array)
                     .mapToInt(Integer::parseInt)
                     .sorted()
                     .toArray();
    }
}
