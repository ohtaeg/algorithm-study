package programmers.kakao.blind2019.candidatekey;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private final List<List<Integer>> permutation;
    private final String[][] relation;
    private final int[] columns;

    public Permutation(final String[][] relation) {
        this.permutation = new ArrayList<>();
        this.relation = relation;
        this.columns = new int[relation[0].length];
    }

    public void permute(final int depth, final int r, final int startIndex) {
        if (depth == r) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                list.add(columns[i]);
            }
            permutation.add(list);
            return;
        }

        for (int i = startIndex; i < relation[0].length; i++) {
            columns[depth] = i;
            permute(depth + 1, r, i + 1);
        }
    }

    public List<List<Integer>> getPermutation() {
        return permutation;
    }
}
