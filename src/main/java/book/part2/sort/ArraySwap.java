package book.part2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArraySwap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstSource = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(firstSource[0]);
        int k = Integer.parseInt(firstSource[1]);

        List<Integer> base = Arrays.stream(bufferedReader.readLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .boxed()
                                   .sorted()
                                   .collect(toList());

        List<Integer> target = Arrays.stream(bufferedReader.readLine().split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .boxed()
                                     .sorted(Collections.reverseOrder())
                                     .collect(toList());

        for (int i = 0; i < k; i++) {
            base.set(i, target.get(i));
        }

        System.out.println(base.stream()
                               .reduce(0, Integer::sum));
        bufferedReader.close();
    }
}
