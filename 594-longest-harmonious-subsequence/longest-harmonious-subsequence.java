class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for(int num : freq.keySet()) {
            if(freq.containsKey(num + 1)) 
            res = Math.max(res, freq.get(num) + freq.get(num + 1));
        }

        return res;
    }
}