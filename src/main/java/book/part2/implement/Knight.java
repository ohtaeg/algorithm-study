package book.part2.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knight {
    private static final int LIMIT_SIZE = 8;
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int[][] KNIGHT_MOVE = {
            new int[]{-1, -2}
            , new int[]{1, -2}
            , new int[]{-1, 2}
            , new int[]{1, 2}
            , new int[]{2, 1}
            , new int[]{2, -1}
            , new int[]{-2, 1}
            , new int[]{-2, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] position = bufferedReader.readLine().split("");

        int x = position[ZERO].charAt(ZERO) - 'a' + ONE;
        int y = Integer.parseInt(position[ONE]);
        int result = calculate(x, y);

        System.out.println(result);
        bufferedReader.close();
    }

    private static int calculate(final int x, final int y) {
        int count = ZERO;
        for (int[] direction : KNIGHT_MOVE) {
            if (isLineIn(direction[ZERO] + x) && isLineIn(direction[ONE] + y)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLineIn(final int position) {
        return position > ZERO && position < LIMIT_SIZE;
    }
}


