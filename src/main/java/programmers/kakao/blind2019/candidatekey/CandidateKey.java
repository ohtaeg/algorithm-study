package programmers.kakao.blind2019.candidatekey;

import java.util.*;

/**
 * 후보키
 * 1. 후보키가 될수있는 모든 조합들을 구한다.
 * 2. 조합들 중에서 유일성을 만족하는 집합만 구한다.
 *  2.1 각 조합에 대해서 유일성을 만족하는지 구한다.
 * 3. 구한 부분집합에서 최소성을 만족하는 부분집합만 남긴다.
 * 4. 해당 부분집합의 갯수를 반환한다.
 */
public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"}
                , {"200", "apeach", "math", "2"}
                , {"300", "tube", "computer", "3"}
                , {"400", "con", "computer", "4"}
                , {"500", "muzi", "music", "3"}
                , {"600", "apeach", "music", "2"}
        };

        CandidateKey candidateKey = new CandidateKey();
        final int solution = candidateKey.solution(relation);
        System.out.println(solution);
    }

    public int solution(String[][] relations) {
        final Permutation permutation = new Permutation(relations);
        for (int r = 1; r <= relations[0].length; r++) {
            permutation.permute(0, r, 0);
        }

        List<List<Integer>> candidateKeys = getAllCandidateKeys(relations, permutation.getPermutation());
        return getMinimalCount(candidateKeys);
    }

    private List<List<Integer>> getAllCandidateKeys(final String[][] relations, final List<List<Integer>> permutations) {
        final int count = relations.length;
        List<List<Integer>> candidateKeys = new ArrayList<>();

        for (List<Integer> columns : permutations) {
            Set<String> tuple = new HashSet<>();
            for (String[] relation : relations) {
                String data = "";
                for (int column : columns) {
                    data += relation[column];
                }
                tuple.add(data);
            }

            if (isUnique(tuple.size(), count)) {
                candidateKeys.add(columns);
            }
        }

        return candidateKeys;
    }

    private boolean isUnique(final int tupleSize, final int length) {
        return tupleSize == length;
    }

    private int getMinimalCount(final List<List<Integer>> candidateKeys) {
        boolean[] isContains = new boolean[candidateKeys.size()];

        for (int i = 0; i < candidateKeys.size() - 1; i++) {
            if (!isContains[i]) {
                List<Integer> candidate = candidateKeys.get(i);
                for (int j = i + 1; j < candidateKeys.size(); j++) {
                    List<Integer> otherCandidate = candidateKeys.get(j);
                    if (otherCandidate.containsAll(candidate)) {
                        isContains[j] = true;
                    }
                }
            }
        }

        return getCount(isContains);
    }

    private int getCount(final boolean[] isContains) {
        int count = 0;
        for (boolean isContain : isContains) {
            if (!isContain) {
                count++;
            }
        }
        return count;
    }
}
