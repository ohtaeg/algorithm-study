package programmers.kakao.blind2020;

/**
 * 연속해서 반벅되는 문자열을 갯수와 값으로 표시, 1은 생략
 * 가장 짧은 단위의 문자열 길이를 반환
 * 1. 들어오는 문자열의 절반의 갯수까지 반복
 * 2. unit 기준으로 연속되는지 확인
 * - 이전 문자열을 기억
 * - 반복문은 unit 기준으로 범위 증가
 * - 현재 문자열과 이전 문자열이 다르면 숫자 계산
 */
public class CompressString {

    public int solution(String source) {
        int result = 1000;
        for (int length = 0; length <= source.length() / 2; length++) {
            String unit = source.substring(0, length + 1);
            int compressedLength = compress(unit, source);
            result = Integer.min(result, compressedLength);
        }
        return result;
    }

    private int compress(final String unit, final String source) {
        final StringBuilder compress = new StringBuilder();
        final int unitLength = unit.length();
        int count = 0;
        String previous = "";

        for (int i = 0; i < source.length(); i += unitLength) {
            String cutting = cut(i, unitLength, source);

            if ("".equals(previous)) {
                previous = cutting;
                count++;
                continue;
            }

            if (previous.equals(cutting)) {
                count++;
            } else {
                concat(compress, previous, count);
                previous = cutting;
                count = 1;
            }
        }

        concat(compress, previous, count);

        return compress.toString()
                       .length();
    }

    private String cut(final int startIndex, final int unitLength, final String source) {
        final int endIndex = startIndex + unitLength;
        if (endIndex > source.length()) {
            return source.substring(startIndex);
        }
        return source.substring(startIndex, endIndex);
    }

    private void concat(final StringBuilder compress, final String previous, final int count) {
        if (count > 1) {
            compress.append(count);
        }
        compress.append(previous);
    }
}
