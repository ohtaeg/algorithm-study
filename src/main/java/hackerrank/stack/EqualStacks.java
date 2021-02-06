package hackerrank.stack;

import java.util.List;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = sum(h1);
        int sum2 = sum(h2);
        int sum3 = sum(h3);
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int min = min(sum1, sum2, sum3);

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 > min && h1.size() > 0) {
                sum1 -= h1.get(index1++);
            }

            if (sum2 > min && h2.size() > 0) {
                sum2 -= h2.get(index2++);
            }

            if (sum3 > min && h3.size() > 0) {
                sum3 -= h3.get(index3++);
            }
            min = min(sum1, sum2, sum3);
        }

        return min;
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
