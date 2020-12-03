package leetcode;

/**
 * Shffle String
 */
public class Q1528 {
    public static void main(String[] args) {
        final Q1528 q1528 = new Q1528();
        final String result = q1528.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3});
        System.out.println(result);
    }

    public String restoreString(String source, int[] indices) {
        final int length = indices.length;
        final String[] sources = new String[length];

        for (int i = 0; i < length; i++) {
            sources[indices[i]] = source.substring(i, i + 1);
        }

        StringBuilder result = new StringBuilder();
        for (String letter : sources) {
            result.append(letter);
        }

        return result.toString();
    }
}
