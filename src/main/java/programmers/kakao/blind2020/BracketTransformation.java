package programmers.kakao.blind2020;

/**
 * 괄호 변환
 */
public class BracketTransformation {
    public static void main(String[] args) {
        BracketTransformation bracketTransformation = new BracketTransformation();
        bracketTransformation.solution(")(");
        bracketTransformation.solution("(()())()");
        bracketTransformation.solution("()))((()");
    }

    public String solution(String source) {
        String answer = convertCorrectBracket(source);
        return answer;
    }

    private String convertCorrectBracket(final String w) {
        if ("".equals(w)) {
            return w;
        }

        int cuttingIndex = cut(w);
        String u = w.substring(0, cuttingIndex);
        String v = w.substring(cuttingIndex);

        if (isCorrect(u)) {
            return u + convertCorrectBracket(v);
        } else {
            StringBuilder result = new StringBuilder("(");
            result.append(convertCorrectBracket(v))
                  .append(")")
                  .append(reverse(u.substring(1, u.length() - 1)));
            return result.toString();
        }
    }

    private int cut(final String w) {
        final int length = w.length();
        int left = 0;
        int right = 0;

        for (int i = 0; i < length; i++) {
            char bracket = w.charAt(i);
            if (isLeft(bracket)) {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                return i + 1;
            }
        }

        return length;
    }

    private boolean isLeft(final char bracket) {
        return bracket == '(';
    }

    private boolean isCorrect(final String u) {
        int count = 0;

        for (int i = 0; i < u.length(); i++) {
            char bracket = u.charAt(i);
            if (isLeft(bracket)) {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private String reverse(final String brackets) {
        StringBuilder reverse = new StringBuilder();
        for (char bracket : brackets.toCharArray()) {
            if (isLeft(bracket)) {
                reverse.append(")");
            } else {
                reverse.append("(");
            }
        }
        return reverse.toString();
    }
}
