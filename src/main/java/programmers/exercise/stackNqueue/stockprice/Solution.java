package programmers.exercise.stackNqueue.stockprice;

public class Solution {
    public int[] solution(int[] prices) {
        return calculate(prices);
    }

    public int[] calculate(final int[] prices) {
        int[] actual = new int[prices.length];
        int count = -1;

        for (int i = 0; i < prices.length; i++) {
            count = 0;
            for (int next = i + 1; next < prices.length; next++) {
                count++;
                if (prices[i] > prices[next]) {
                    break;
                }
            }
            actual[i] = count;
        }
        return actual;
    }
}


