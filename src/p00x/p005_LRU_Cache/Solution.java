/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p005_LRU_Cache;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * </pre>
 *
 * @author leo
 */
public class Solution {

    /**
     * 17 / 17 test cases passed.
     * Status: Accepted
     * Runtime: 580 ms
     */
    public static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super((int) (capacity / 0.75f), 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer v = super.get(key);

            return v == null ? -1 : v;
        }

        public void set(int key, int value) {
            put(key, value);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
 