class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>(); // grouped string

        // Pad the string with the fill character until its length is divisible by k
        while(s.length() % k != 0) {
            s += fill;
        }
        // Split the string into k-length parts
        StringBuilder cur = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            cur.append(s.charAt(i));
            if(cur.length() == k) {
                ans.add(cur.toString());
                cur = new StringBuilder(); // reset for next grp
            }
        }
        // Convert list to array and return 
        return ans.toArray(new String[0]);
    }
}