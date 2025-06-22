class Solution {
    public String longestPalindrome(String s) {
        for(int len = s.length(); len > 0; len--) {
            for(int strt = 0; strt <= s.length() - len; strt++) {
                if(check(strt, strt + len, s)) {
                    return s.substring(strt, strt + len);
                }
            }
        }
        return "";
    }
    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}