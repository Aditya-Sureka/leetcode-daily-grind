class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int largestCount = 0, beg = 0, maxlen = 0;
        for(int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            if(end - beg + 1 - largestCount > k) {
                arr[s.charAt(beg) - 'A']--;
                beg++;
            }
            maxlen = Math.max(maxlen, end - beg + 1);
        }
        return maxlen;
    }
}