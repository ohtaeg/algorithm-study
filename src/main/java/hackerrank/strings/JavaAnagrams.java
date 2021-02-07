package hackerrank.strings;

/**
 * 이 문제는 쉬워보이지만 import가 불가하기 때문에 자료구조 사용이 불가능하다.
 * 자료구조 사용없이 애너그램을 판별할 수 있어야 하는 문제이다.
 */
public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        final char[] aa = a.toLowerCase()
                           .toCharArray();
        final char[] bb = b.toLowerCase()
                           .toCharArray();
        int[] counts = new int[26];

        for (int i = 0; i < aa.length; i++) {
            counts[aa[i] - 'a']++;
            counts[bb[i] - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
