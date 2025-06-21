class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int l = 0;
        while(l < 26 && freq[l] == 0) l++;

        int n = 26;
        int ans = Integer.MAX_VALUE;
        for(int i = l; i < n; i++) {
            int range = freq[i] + k;
            int total = freq[i];

            for(int j = i + 1; j < n; j++) {
                if(freq[j] > range) {
                    total += range;
                } else {
                    total += freq[j];
                }
            }
            int remain = word.length() - total;
            ans = Math.min(ans, remain);
        }
        return ans;
    }
}