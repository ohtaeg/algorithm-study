package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        br.close();

        StringBuilder builder = new StringBuilder();
        String[] suffixes = new String[source.length()];

        for (int i = 0; i < source.length(); i++) {
            suffixes[i] = source.substring(i);
        }

        //Arrays.sort(suffixes);
        final String[] sorted = textSort(suffixes);
        for (int i = 0; i < source.length(); i++) {
            builder.append(sorted[i]).append(System.lineSeparator());
        }
        System.out.println(builder.toString());
    }

    public static String[] textSort(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }
}
