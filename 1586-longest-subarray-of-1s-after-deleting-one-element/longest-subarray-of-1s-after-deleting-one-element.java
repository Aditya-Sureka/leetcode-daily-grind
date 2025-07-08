class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0, longestWindow = 0;
        //left end of window
        int  start = 0;

        for(int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);

            //Shrink the window until count of 0's is <= 1
            while(zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }
}