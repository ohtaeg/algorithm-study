package book.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 만들 수 없는 금액
 *
 */
public class NonCreatableAmount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        String[] source = bufferedReader.readLine().split(" ");

        int target = 1;
        for (String letter : source) {
            int data = Integer.parseInt(letter);
            if (target < data) {
                break;
            } else {
                target += data;
            }
        }
        System.out.println(target);
    }
}
