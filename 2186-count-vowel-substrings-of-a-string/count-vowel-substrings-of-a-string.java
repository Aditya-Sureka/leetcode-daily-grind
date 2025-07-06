public class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int countVowelSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        

        for (int i = 0; i < n; ++i) {
            Map<Character, Integer> cnt = new HashMap<>();
            for (int j = i; j < n && isVowel(s.charAt(j)); ++j) {
                cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j), 0) + 1);
                if (cnt.size() == 5) ++ans;
            }
        }
        return ans;
    }
}