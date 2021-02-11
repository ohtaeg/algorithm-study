package programmers.level2.joystick;

/**
 * 좌우 움직이는 로직으로 인해 테스트케이스가 통과가 되지 않아 블로그를 참고
 * 이 문제는 아직 말이 많다. 나중에 재 풀이 할것.
 */
public class Solution {
    public int solution(String name) {
        int answer = 0;
        int sideMoveCount = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            answer += moveUpDown(letter);

            int a = moveLeftRight(name, i);
            sideMoveCount = Integer.min(sideMoveCount, a);
        }
        return answer + sideMoveCount;
    }

    private int moveLeftRight(final String name, final int current) {
        int length = name.length();
        int next = current + 1;
        while (next < length && name.charAt(next) == 'A') {
            next++;
        }

        return current + length - next + current;

    }

    private int moveUpDown(final char letter) {
        int upCount = up(letter);
        int downCount = down(letter);
        return Integer.min(upCount, downCount);
    }

    private int up(final char letter) {
        return letter - 'A';
    }

    private int down(final char letter) {
        return 'Z' - letter + 1;
    }
}
