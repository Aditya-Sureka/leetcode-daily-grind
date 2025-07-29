class Solution {
    private boolean isSet(int num, int pos) {
        return (num & (1 << pos)) != 0;
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] suf = new int[n];

        // suffix OR
        suf[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }
        int l = 0, r = 0;
        int cur = nums[0];
        int[] freq = new int[32];

        // initial freq update
        for(int j = 0; j < 32; j++) {
            if(isSet(nums[0], j)) {
                freq[j]++;
            }
        }
        while(l < n) {
            while(r + 1 < n && cur != suf[l]) {
                r++;
                cur |= nums[r];
                for(int j = 0; j < 32; j++) {
                    if(isSet(nums[r], j)) {
                        freq[j]++;
                    }
                }
            }
            res[l]  = Math.max(1, r - l + 1);

            for(int j = 0; j < 32; j++) {
                if(isSet(nums[l], j)) {
                    freq[j]--;
                    if(freq[j] == 0) {
                        cur = cur & (~(1 << j));
                    }
                }
            }
            l++;
        }
        return res;
    }
}