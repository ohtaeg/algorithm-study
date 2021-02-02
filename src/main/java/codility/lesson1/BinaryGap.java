package codility.lesson1;

public class BinaryGap {

    public int solution(int n) {
        int result = 0;
        int max = 0;
        boolean isStartOne = false;

        while (n > 0) {
            if (n % 2 == 0) {
                if (isStartOne) {
                    max++;
                }
            } else { // 1을 만났을 떄
                if (!isStartOne) { // 처음 1일 때
                    isStartOne = true;
                } else { // 1로 둘러쌓였을 떄
                    result = Integer.max(result, max);
                    max = 0;
                }
            }
            n /= 2;
        }
        return result;
    }
}
