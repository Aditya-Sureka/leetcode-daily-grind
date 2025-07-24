class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> record = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(!record.isEmpty() && temperatures[i] > temperatures[record.peek()]) {
                int idx = record.pop();
                ans[idx] = i - idx;
            }
            record.push(i);
        }
        return ans;
     }
}