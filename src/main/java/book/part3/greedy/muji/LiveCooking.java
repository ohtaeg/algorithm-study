package book.part3.greedy.muji;

import java.util.*;

public class LiveCooking {
    public static void main(String[] args) {
        int[] food_times = {3, 5, 1, 6, 5, 3};
        int k = 20;
        System.out.println(reSolution(food_times, k)); // 4
    }

    /**
     * 다른 사람 풀이 참고했기에 해당 문제는 다시 풀어봐야함
     * @param food_times
     * @param k
     * @return
     */
    public static int reSolution(int[] food_times, long k) {
        List<Food> foods = init(food_times);
        int foodLength = food_times.length;
        int previousTime = 0;
        int index = 0;

        for (Food food : foods) {
            long gap = food.getGap(previousTime);
            if (gap != 0) {
                long spend = gap * foodLength;
                if (spend <= k) {
                    k -= spend;
                    previousTime = food.getTime();
                } else {
                    k %= foodLength;
                    Collections.sort(foods.subList(index, food_times.length), Comparator.comparingInt(Food::getIndex));
                    return foods.get(index + (int) k).getIndex();
                }
            }
            index++;
            foodLength--;
        }
        return -1;
    }

    private static List<Food> init(final int[] foodTimes) {
        List<Food> foods = new LinkedList<>();
        for (int i = 0; i < foodTimes.length; i++) {
            foods.add(new Food(i + 1, foodTimes[i]));
        }
        Collections.sort(foods);
        return foods;
    }

    /**
     * 첫 도전, 정확성만 통과, 효율성 통과 못함
     * @param food_times
     * @param k
     * @return
     */
    public static int solution(int[] food_times, long k) {
        int answer = 0;
        final int length = food_times.length;
        long sum = Arrays.stream(food_times)
                         .sum();

        while (k >= 0) {
            // 더이상 섭취할 음식이 없다면 -1
            if (sum == 0) {
                return -1;
            }

            if (answer >= length) {
                answer = 0;
            }

            int time = food_times[answer];
            if (time == 0) {
                answer++;
                continue;
            }

            food_times[answer++] = time - 1;
            sum--;
            k--;
        }
        return answer;
    }
}
