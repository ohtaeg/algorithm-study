package book.part3.implement;

import java.util.Scanner;

public class LuckStraight {
    private static final String LUCKY = "LUCKY";
    private static final String READY = "READY";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String score = scanner.nextLine();

        System.out.println(calculateLuckyStraight(score));
    }

    private static String calculateLuckyStraight(final String score) {
        String left = score.substring(0, score.length() / 2);
        String right = score.substring(score.length() / 2);

        if (sum(left) == sum(right)) {
            return LUCKY;
        }
        return READY;
    }

    private static int sum(final String score) {
        int sum = 0;
        for (char value : score.toCharArray()) {
            sum += value - '0';
        }
        return sum;
    }
}
