class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int old_covered = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int l_range = Math.max(0, i - k);
                int r_range = Math.min(n - 1, i + k);

                int start = Math.max(l_range, old_covered + 1);

                for (int j = start; j <= r_range; j++) {
                    ans.add(j);
                }

                old_covered = r_range;
            }
        }

        return ans;
    }
}