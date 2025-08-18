class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') counter--;
            if(counter != 0) ans.append(s.charAt(i));
            if(s.charAt(i) == '(') counter++;
        }
        return ans.toString();
    }
}