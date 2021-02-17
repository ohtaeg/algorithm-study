package hackerrank.implementation;

public class Encryption {

    static String encryption(String s) {
        String source = s.replace(" ", "");
        final int length = source.length();
        int sqrt = (int) Math.sqrt(length);
        int row, col;

        if (isSqrt(sqrt, length)) {
            row = sqrt;
            col = sqrt;
        } else {
            row = sqrt;
            col = sqrt + 1;
        }

        if (row * col < length) {
            row++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int index = col * j + i;
                if (index < length) {
                    result.append(source.substring(index, index + 1));
                }
            }

            if (i != col - 1) {
                result.append(" ");
            }
        }

        return result.toString()
                     .trim();
    }

    private static boolean isSqrt(final int sqrt, final int length) {
        return sqrt * sqrt == length;
    }
}
