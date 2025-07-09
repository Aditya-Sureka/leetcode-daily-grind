class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Set<Integer> s = new HashSet<>();
        for(int x : map.values()) {
            s.add(x);
        }
        return map.size() == s.size();
    }
}