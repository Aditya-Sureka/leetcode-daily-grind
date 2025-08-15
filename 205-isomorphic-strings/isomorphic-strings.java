class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        int m = s.length();
        for(int i = 0; i < m; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if((map1[ch1] != -1 && map1[ch1] != ch2) || (map2[ch2] != -1 && map2[ch2] != ch1)) 
                return false;
            
            map1[ch1] = ch2;
            map2[ch2] = ch1;
        }
        return true;
    }
}