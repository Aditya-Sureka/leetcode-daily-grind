class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxOpr = 0;
        while(left < right) {
            if(nums[left] + nums[right] == k) {
                maxOpr++;
                left++;
                right--;
            } else if(nums[left] + nums[right] > k) {
                right--;
            } else {
               left++;
            }
        }
        return maxOpr;
        
    }
}

// [1, 3, 3, 3, 4] k = 6