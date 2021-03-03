package programmers.exercise.sort.kth;

import java.util.Arrays;

public class NumberOfKth {
    public int[] solution(int[] array, int[][] commands) {
        final int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] sorted = sort(array, command);
            answer[i++] = sorted[command[2] - 1];
        }
        return answer;
    }

    private int[] sort(final int[] array, final int[] command) {
        int[] copy = Arrays.copyOfRange(array, command[0] - 1, command[1]);
        Arrays.sort(copy);
        return copy;
    }
}
