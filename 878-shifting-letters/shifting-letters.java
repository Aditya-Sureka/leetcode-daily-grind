class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        int X = 0;

        for(int shift : shifts) {
            X = (X + shift) % 26;
        }

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            sb.append((char)((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
            
        }
        return sb.toString();
        
    }
}