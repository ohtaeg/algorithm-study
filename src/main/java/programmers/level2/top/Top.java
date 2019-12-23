package programmers.level2.top;

class Top extends Solution {
    @Override
    public int[] solution(final int[] heights) {
        int length = heights.length;
        int[] answer = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            answer[i] = recept(heights, i);
        }
        return answer;
    }

    public int recept(final int[] source, final int start) {
        for (int i = start; i > 0; i--) {
            if (source[i - 1] > source[start]) {
                return i;
            }
        }
        return 0;
    }
}
