package book.part2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 숫자 카드 게임
 */
public class CardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputNM = bufferedReader.readLine();

        final int n = parseInt(inputNM.split(" ")[0]); // 행
        final int m = parseInt(inputNM.split(" ")[1]); // 열
        final int[][] cards = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] rowData = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                cards[i][j] = parseInt(rowData[j]);
            }
        }

        int result = pickCard(cards);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int parseInt(final String input) {
        return Integer.parseInt(input);
    }


    private static int pickCard(final int[][] cards) {
        // TODO : 다음에 할때는 배열을 사용하지 않고 해볼것
        final int[] smallNumbers = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            smallNumbers[i] = min(cards[i]);
        }
        return max(smallNumbers);
    }

    private static int min(final int[] numbers) {
        return Arrays.stream(numbers)
                     .min()
                     .getAsInt();
    }

    private static int max(final int[] numbers) {
        return Arrays.stream(numbers)
                     .max()
                     .getAsInt();
    }
}
