package codility.lesson3;

public class FrogJump {
    public int solution(int x, int y, int d) {
        if (x == y) {
            return 0;
        }

        int diff = y - x;
        if (d > diff) {
            return 1;
        }

        return diff % d == 0 ? diff / d : diff / d + 1;
    }
}
