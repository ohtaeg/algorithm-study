package book.part2.binarysearch.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ComponentSet {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] components = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(bufferedReader.readLine());
        String[] targets = bufferedReader.readLine().split(" ");

        StringBuilder result = new StringBuilder();
        for (String target : targets) {
            result.append(find(components, target));
        }

        System.out.println(result.toString());
        bufferedReader.close();
    }

    private static String find(final String[] components, final String target) {
        Set<String> set = new HashSet<>();
        for (String component : components) {
            set.add(component);
        }

        if (set.contains(target)) {
            return YES;
        }
        return NO;
    }
}
