package book.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String source = bufferedReader.readLine();

        int result = reverse(source);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int reverse(final String source) {
        int zeroConvertCount = 0;
        int oneConvertCount = 0;

        if (source.charAt(0) == '1') {
            zeroConvertCount++;
        } else {
            oneConvertCount++;
        }

        for (int i = 0; i < source.length() - 1; i++) {
            if (source.charAt(i) != source.charAt(i + 1)) {
                if (source.charAt(i + 1) == '1') {
                    zeroConvertCount++;
                } else {
                    oneConvertCount++;
                }
            }
        }

        return Integer.min(zeroConvertCount, oneConvertCount);
    }
}
