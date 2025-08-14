class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String ans = "";
        for(int i = 0; i <= n - 3; i++) {
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triple = "" + num.charAt(i) + num.charAt(i) + num.charAt(i);
                if(ans.isEmpty() || triple.compareTo(ans) > 0) {
                ans = triple;
            }
            }
           
        }
        return ans;
    }
}