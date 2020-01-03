package programmers.level3.bestalbum;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> actual = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, List<GenreSpec>> genreMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            String key = genres[i];
            int count = plays[i];
            // 1. 장르별 스펙리스트를 담는 Map Setting
            countMap.put(key, countMap.getOrDefault(key, 0) + count);

            // 2. 장르별 총 재생횟수 Map Setting
            List<GenreSpec> list = genreMap.getOrDefault(key, new ArrayList<>());
            list.add(new GenreSpec(i, count));
            genreMap.put(key, list);
        }

        // 3. 총 재생횟수가 큰 순으로 장르 sorting.
        List<Map.Entry<String, Integer>> sortedKeys = new LinkedList<>(countMap.entrySet());
        sortedKeys.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // 4. 가장 많이 재생된 장르 스펙으로 정렬 후 두개씩 추출
        for (Map.Entry<String, Integer> ganre : sortedKeys) {
            String key = ganre.getKey();
            List<GenreSpec> list = genreMap.get(key);
            Collections.sort(list);

            Iterator<GenreSpec> iterator = list.iterator();
            for (int i=0; i<2; i++) {
                if (iterator.hasNext()) {
                    GenreSpec genreSpec = iterator.next();
                    actual.add(genreSpec.getIndex());
                }
            }
        }
        return actual.stream().mapToInt(Integer::intValue).toArray();
    }
}
