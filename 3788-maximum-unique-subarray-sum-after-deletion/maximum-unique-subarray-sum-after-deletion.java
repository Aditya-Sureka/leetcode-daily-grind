class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int mn = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            if(!hs.contains(num)) {
                if(num >= 0) {
                    sum += num;
                } else {
                    mn = Math.max(mn, num);
                }
            }
            hs.add(num);
        }
        if(sum == 0 && !hs.contains(0)) {
            return mn;
        }
        return sum;
    }
}