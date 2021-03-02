package programmers.exercise.bruteforce.carpet;

/**
 * 규칙을 찾아 공식화를 시켜 완전탐색하면서 공식에 맞는 경우를 리턴하면 되는 문제
 * x가 넓이 y가 높이일때, x = 3, y = 3이면 (2x - 2) + (2y - 2) = brown 갯수 라는 규칙이 찾아진다.
 * 이 공식을 이용하여 높이는 yellow가 1일때 최소 3이기 때문에 3부터 높이를 하나하나 높여가며 width를 구해가며 yellow 갯수가 맞는지 판단
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        for (int height = 3; height < brown; height++) {
            int width = (brown + 4) / 2 - height;

            if (width * height - brown == yellow) {
                return new int[]{width, height};
            }
        }
        return new int[]{-1, -1};
    }
}
