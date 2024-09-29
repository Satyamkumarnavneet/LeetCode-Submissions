class AllOne {
    private Map<String, Integer> hash;
    private List<String> keys;

    public AllOne() {
        hash = new HashMap<>();
        keys = new ArrayList<>();
    }

    public void inc(String key) {
        if (!hash.containsKey(key)) {
            hash.put(key, 0);
            keys.add(key);
        }
        hash.put(key, hash.get(key) + 1);
        int value = hash.get(key);
        keys.remove(key);
        int low = 0, high = keys.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (hash.get(keys.get(mid)) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        keys.add(low, key);
    }

    public void dec(String key) {
        if (!hash.containsKey(key)) return;
        hash.put(key, hash.get(key) - 1);
        int value = hash.get(key);
        if (value == 0) {
            hash.remove(key);
            keys.remove(key);
        } else {
            keys.remove(key);
            int low = 0, high = keys.size();
            while (low < high) {
                int mid = (low + high) / 2;
                if (hash.get(keys.get(mid)) < value) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            keys.add(low, key);
        }
    }

    public String getMinKey() {
        return keys.isEmpty() ? "" : keys.get(0);
    }

    public String getMaxKey() {
        return keys.isEmpty() ? "" : keys.get(keys.size() - 1);
    }
}
