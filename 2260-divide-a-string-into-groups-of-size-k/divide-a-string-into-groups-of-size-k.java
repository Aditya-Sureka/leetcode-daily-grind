class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>(); 
        StringBuilder cur = new StringBuilder();

         for(int i = 0; i < s.length(); i++) {
            cur.append(s.charAt(i));
            if(cur.length() == k) {
                ans.add(cur.toString());
              cur.setLength(0); //reset the builder efficiently
            }
        }

        // Handlr last group if its not full
        if(cur.length() > 0) {
            while(cur.length() < k) {
                cur.append(fill);
            }
            ans.add(cur.toString());
        }
        
       
        // Convert list to array and return 
        return ans.toArray(new String[0]);
    }
}