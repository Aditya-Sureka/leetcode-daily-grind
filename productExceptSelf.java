class Solution {
    public int[] productExceptSelf(int[] nums) {
        // O(n)
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        // Fill prefix(left) array
        for(int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Fill suffix(right) array
        for(int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Calculate the result
        for(int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
        
    }
}