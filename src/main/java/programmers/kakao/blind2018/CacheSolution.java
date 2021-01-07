package programmers.kakao.blind2018;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheSolution {

    public int solution(int cacheSize, String[] cities) {
        final int data = -1;
        int answer = 0;
        LRUCache cache = LRUCache.create(cacheSize);

        for (String city : cities) {
            String lower = city.toLowerCase();
            if (cache.containsKey(lower)) {
                cache.get(lower);
                answer += 1;
            } else {
                cache.put(lower, data);
                answer += 5;
            }
        }

        return answer;
    }
}

class LRUCache extends LinkedHashMap {
    private final int size;

    private LRUCache(final int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    public static LRUCache create(final int size) {
        return new LRUCache(size);
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry eldest) {
        return size() > size;
    }
}
