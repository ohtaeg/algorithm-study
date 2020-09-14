package book.part2.implement.updownleftright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상하좌우
 */
public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final String[] commands = bufferedReader.readLine().split(" ");

        String result = move(n, commands);

        System.out.println(result);
        bufferedReader.close();
    }

    private static String move(final int n, final String[] commands) {
        Point point = new Point(1, 1);
        for (String command : commands) {
            final Direction direction = Direction.of(command);
            point = direction.move(point, n);
        }
        return point.toString();
    }
}

