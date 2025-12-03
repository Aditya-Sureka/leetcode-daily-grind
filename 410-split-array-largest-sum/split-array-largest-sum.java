class Solution {
    public int splitArray(int[] nums, int k) {

    if(k > nums.length) return -1;

    int low = Arrays.stream(nums).max().getAsInt();
    int high = Arrays.stream(nums).sum();

    while(low <= high) {
        int mid = (low + high) / 2;
        int ans = largeSum(nums, mid);
        if(ans > k) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low;
}

    public int largeSum(int[] nums, int maxSum) {
        int partition = 1, subArraySum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(subArraySum + nums[i] <= maxSum) {
                subArraySum += nums[i];
            } else {
                partition++;
                subArraySum = nums[i];
            }
        }
        return partition;
    }
}