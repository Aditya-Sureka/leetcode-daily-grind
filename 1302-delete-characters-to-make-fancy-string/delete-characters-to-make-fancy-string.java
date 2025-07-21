class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i < 2 || s.charAt(i) != str.charAt(str.length() - 1) || s.charAt(i) != str.charAt(str.length() - 2)){
                str.append(s.charAt(i));
            }    
        }
        return str.toString();
    }
}