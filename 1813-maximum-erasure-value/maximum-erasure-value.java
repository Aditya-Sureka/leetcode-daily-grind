class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int sum = 0, max = 0;

        while (r < nums.length) {
            if (map.containsKey(nums[r]) && map.get(nums[r]) > 0) {
                while (map.get(nums[r]) > 0) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    sum -= nums[l];
                    l++;
                }
            }

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];
            max = Math.max(max, sum);
            r++;
        }

        return max;
    }
}