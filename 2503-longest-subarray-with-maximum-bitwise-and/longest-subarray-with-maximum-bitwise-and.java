class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int maxStreak = 0;
        int max = nums[0];
        for(int n : nums) {
            if(n > max) max = n;
        }
       for(int n : nums) {
        if(n == max) {
            count++;
            maxStreak = Math.max(maxStreak, count);
        } else {
            count = 0;
        }
    }
    return maxStreak;
    }
}