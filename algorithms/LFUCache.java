import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int cap;

    public LFUCache(int cap) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.cap = cap;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return Integer.MIN_VALUE;
        }

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToVal.size()) {
            removeLeastFreq();
        }

        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        // Obtain origin freq
        int freq = keyToFreq.get(key);
        // Increase freq
        keyToFreq.put(key, freq + 1);
        // Remove key from origin freq queue
        freqToKeys.get(freq).remove(key);
        // Put new freq queue in freq map
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        // Add key to new freq queue
        freqToKeys.get(freq + 1).add(key);
        // Handle origin freq queue
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (this.minFreq = freq) {
                this.minFreq = freq + 1;
            }
        }
    }

    private void removeLeastFreq() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // Note: no need to update minFreq here, guess why
        }
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}
