class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> vp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            vp.add(new int[]{nums[i], i}); 
        }

        // Sort by value (ascending)
        vp.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> tmp = new ArrayList<>();
        for (int i = vp.size() - 1; i >= 0 && k > 0; i--, k--) {
            tmp.add(new int[]{vp.get(i)[1], vp.get(i)[0]}); // store (index, value)
        }

        // Sort by original index to maintain original order
        tmp.sort(Comparator.comparingInt(a -> a[0]));

        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i)[1];
        }

        return ans;
    }
}