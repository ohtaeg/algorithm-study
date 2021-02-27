package programmers.exercise.bruteforce.mocktest;

public class MockTest {
    private static final int[] PERSON_A = {
            1, 2, 3, 4, 5
    };
    private static final int[] PERSON_B = {
            2, 1, 2, 3, 2, 4, 2, 5
    };
    private static final int[] PERSON_C = {
            3, 3, 1, 1, 2, 2, 4, 4, 5, 5
    };

    public int[] solution(int[] answers) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == PERSON_A[i % PERSON_A.length]) {
                aCount++;
            }

            if (answer == PERSON_B[i % PERSON_B.length]) {
                bCount++;
            }

            if (answer == PERSON_C[i % PERSON_C.length]) {
                cCount++;
            }
        }

        int max = max(aCount, bCount, cCount);
        int count = count(aCount, bCount, cCount, max);
        int index = 0;
        int[] result = new int[count];

        if (max == aCount) {
            result[index++] = 1;
        }

        if (max == bCount) {
            result[index++] = 2;
        }

        if (max == cCount) {
            result[index++] = 3;
        }

        return result;
    }

    private int count(final int aCount, final int bCount, final int cCount, final int max) {
        int count = 0;
        if (max == aCount) {
            count++;
        }

        if (max == bCount) {
            count++;
        }

        if (max == cCount) {
            count++;
        }

        return count;
    }

    private int max(final int aCount, final int bCount, final int cCount) {
        int max = 0;
        max = Integer.max(aCount, max);
        max = Integer.max(bCount, max);
        max = Integer.max(cCount, max);
        return max;
    }
}
