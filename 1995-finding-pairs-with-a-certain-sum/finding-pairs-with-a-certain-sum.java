class FindSumPairs {
    int[] a, b;
    Map<Integer, Integer> uma = new HashMap<>();
    Map<Integer, Integer> umb = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        a = nums1;
        b = nums2;

        for (int num : nums1)
            uma.put(num, uma.getOrDefault(num, 0) + 1);

        for (int num : nums2)
            umb.put(num, umb.getOrDefault(num, 0) + 1);
    }

    public void add(int index, int val) {
        umb.put(b[index], umb.get(b[index]) - 1);
        b[index] += val;
        umb.put(b[index], umb.getOrDefault(b[index], 0) + 1);
    }

    public int count(int tot) {
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : uma.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();
            int remain = tot - val;
            pairs += freq * umb.getOrDefault(remain, 0);
        }
        return pairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */