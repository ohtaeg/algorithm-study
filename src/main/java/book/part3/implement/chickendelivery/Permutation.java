package book.part3.implement.chickendelivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    private final List<List<Position>> combinations;
    private final List<Position> chickens;
    private final int[] indexes;
    private final int r;

    public Permutation(final List<Position> chickens, final int r) {
        this.r = r;
        this.chickens = chickens;
        this.combinations = new ArrayList<>();
        this.indexes = new int[r];
    }

    public void permute(final int depth, final int index) {
        if (depth == r) {
            List<Position> chickenPositions = new ArrayList<>();
            for (int i = 0; i < indexes.length; i++) {
                chickenPositions.add(chickens.get(indexes[i]));
            }
            combinations.add(chickenPositions);
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            indexes[depth] = i;
            permute(depth + 1, i + 1);
        }
    }

    public List<List<Position>> getResult() {
        return Collections.unmodifiableList(combinations);
    }
}
