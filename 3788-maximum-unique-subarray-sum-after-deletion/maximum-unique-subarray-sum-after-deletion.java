class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) {
            if(num > 0) {
                hs.add(num);
            }
        }
        if(hs.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return hs.stream().mapToInt(Integer::intValue).sum();
    }
}