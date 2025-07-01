class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1;

        while(end >= 0) {
            if(s.charAt(end) == ' ') {
                end--;
                continue;
            }
            int start = end;
            while(start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            result.append(s.substring(start + 1, end + 1)).append(" ");
            end = start;
        } 
        return result.toString().trim();
  }
}