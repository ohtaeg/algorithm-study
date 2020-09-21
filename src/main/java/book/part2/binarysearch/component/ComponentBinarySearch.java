package book.part2.binarysearch.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 부품 찾기
 */
public class ComponentBinarySearch {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] components = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(bufferedReader.readLine());
        String[] targets = bufferedReader.readLine().split(" ");

        StringBuilder result = new StringBuilder();
        for (String target : targets) {
            result.append(find(components, target));
        }

        System.out.println(result.toString());
        bufferedReader.close();
    }

    private static String find(final String[] array, final String target) {
        final int[] components = convertIntegerArray(array);
        Arrays.sort(components);
        return searchBinary(components, Integer.parseInt(target), 0, components.length - 1);
    }

    private static int[] convertIntegerArray(final String[] array) {
        return Arrays.stream(array)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private static String searchBinary(final int[] components, final int target, int start, int end) {
        if (start > end) {
            return NO;
        }

        int mid = (start + end) / 2;
        if (components[mid] == target) {
            return YES;
        }

        if (components[mid] > target) {
            return searchBinary(components, target, start, mid - 1);
        }

        if (components[mid] < target) {
            return searchBinary(components, target, mid + 1, end);
        }

        return NO;
    }
}
