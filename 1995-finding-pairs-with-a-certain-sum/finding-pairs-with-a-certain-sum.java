class FindSumPairs {
    int[] a, b;
    Map<Integer, Integer> umb = new HashMap<>();
    int mx = 0;

    public FindSumPairs(int[] nums1, int[] nums2) {
        a = nums1.clone();
        b = nums2;
        Arrays.sort(a);

        for(int val : b) {
            umb.put(val, umb.getOrDefault(val, 0) + 1);
            mx = Math.max(mx, val);
        }
    }
    
    public void add(int index, int val) {
        umb.put(b[index], umb.get(b[index]) - 1);
        b[index] += val;
        mx = Math.max(mx, b[index]);
        umb.put(b[index], umb.getOrDefault(b[index], 0) + 1);
    }
    
    public int count(int tot) {
        int pairs  = 0;
        int start = Arrays.binarySearch(a, tot - mx - 1);
        if(start < 0) start = 0;

        for(int i = start; i < a.length; i++) {
            int remain = tot - a[i];
            pairs += umb.getOrDefault(remain, 0);
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