package codility.lesson4;

public class FrogRiverOne {
    public int solution(int x, int[] positions) {
        boolean[] isPassable = new boolean[x + 1];
        int sum = x * (x + 1) / 2;
        int currentSum = 0;

        for (int time = 0; time < positions.length; time++) {
            int position = positions[time];
            if (!isPassable[position]) {
                isPassable[position] = true;
                currentSum += position;
            }

            if (sum == currentSum) {
                return time;
            }
        }

        return -1;

    }
}
