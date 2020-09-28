package book.part3.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 안테나
 * 합이 최솟값이 되는 기준은 무엇일까?
 * 정렬을 한뒤 중간값으로 하면 평균이 된다.
 */
public class Antenna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }

        System.out.println(setAntenna(positions, n));
    }

    private static int setAntenna(final int[] positions, final int n) {
        Arrays.sort(positions);
        return positions[(n - 1)/ 2];
    }
}
