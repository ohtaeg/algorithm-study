package book.part3.implement.wallinspection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    private static final boolean VISIT = Boolean.TRUE;

    private static int[] friends;
    private static boolean[] isVisit;
    private final int r;
    private final List<List<Integer>> result;

    public Permutation(final int length) {
        this.friends = new int[length];
        this.isVisit = new boolean[length];
        this.r = length;
        this.result = new ArrayList<>();
    }

    public void permute(final int[] dist, final int depth) {
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                temp.add(friends[i]);
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i < r; i++) {
            if (!isVisit[i]) {
                friends[depth] = dist[i];
                isVisit[i] = VISIT;
                permute(dist, depth + 1);
                isVisit[i] = !VISIT;
            }
        }
    }

    public List<List<Integer>> getResult() {
        return Collections.unmodifiableList(result);
    }
}
