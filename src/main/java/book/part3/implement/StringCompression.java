package book.part3.implement;

import java.util.*;

/**
 * 문자열 압축
 *
 * 1. 문자열 길이의 절반까지를 단위로 잡고 수행한다.
 *     - 왜냐하면 절반보다 크면 2단위 이상 나눌 수 없기 때문에
 * 2. 이전 문자열과 다음 문자열을 구한 후, 같은지 다른지 비교하면서 진행한다.
 *     - 같으면 카운트 증가
 *     - 다르면 카운트 및 자른 문자열을 결과에 더해준다. ( 카운트가 1일 경우 숫자 생략 )
 * 3. 1~2번을 반복하며 문자열의 길이를 비교하여 최솟값을 구한다.
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String source = scanner.nextLine();
        int result = solution(source);
        System.out.println(result);
    }

    public static int solution(String source) {
        int min = source.length();

        for (int cutUnit = 1; cutUnit <= source.length() / 2; cutUnit++) {
            StringBuilder compressionResult = new StringBuilder();
            String previous = cut(source, 0, cutUnit);
            int count = 1;

            for (int startIndex = cutUnit; startIndex < source.length(); startIndex += cutUnit) {
                String cuttingWord = cut(source, startIndex, cutUnit);
                if (previous.equals(cuttingWord)) {
                    count++;
                } else {
                    concat(count, compressionResult, previous);
                    count = 1;
                    previous = cuttingWord;
                }
            }
            concat(count, compressionResult, previous);
            min = Integer.min(min, compressionResult.length());
        }
        return min;
    }

    private static String cut(final String source, final int startIndex, final int cutUnit) {
        int endIndex = startIndex + cutUnit;
        if (startIndex + cutUnit >= source.length()) {
            endIndex = source.length();
        }
        return source.substring(startIndex, endIndex);
    }

    private static void concat(final int count, final StringBuilder compressionResult, final String previous) {
        if (isOverlap(count)) {
            compressionResult.append(count);
        }
        compressionResult.append(previous);
    }

    private static boolean isOverlap(final int count) {
        return count != 1;
    }
}
