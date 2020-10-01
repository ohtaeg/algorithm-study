package boj.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 일곱 난쟁이
 * 7개의 숫자를 반복문으로 돌리면서 100이 맞는지 찾는것보다
 * 9개의 숫자를 다 더한 다음 두개씩 뺴면서 100이 되는지 확인하는 방법으로 구현
 */
public class Q2309 {
    private static final int MAX = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> heights = new ArrayList<>(MAX);
        int sum = 0;

        for (int i = 0; i < MAX; i++) {
            int height = scanner.nextInt();
            heights.add(height);
            sum += height;
        }

        List<Integer> result = findSevenDwarfs(heights, sum);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static List<Integer> findSevenDwarfs(final List<Integer> heights, final int sum) {
        int firstHeight = 0;
        int secondHeight = 0;
        boolean isSearch = false;

        for (int i = 0; i < MAX - 1; i++) {
            if (isSearch) {
                break;
            }
            firstHeight = heights.get(i);
            for (int j = i + 1; j < MAX; j++) {
                secondHeight = heights.get(j);
                if (sum - firstHeight - secondHeight == 100) {
                    isSearch = true;
                    break;
                }
            }
        }

        heights.remove((Integer) firstHeight);
        heights.remove((Integer) secondHeight);
        Collections.sort(heights);
        return heights;
    }
}
