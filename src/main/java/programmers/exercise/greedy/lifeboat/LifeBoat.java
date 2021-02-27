package programmers.exercise.greedy.lifeboat;

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int kg = people[left] + people[right];
            if (kg <= limit) {
                left++;
            }
            right--;
            result++;
        }


        return result;
    }
}
