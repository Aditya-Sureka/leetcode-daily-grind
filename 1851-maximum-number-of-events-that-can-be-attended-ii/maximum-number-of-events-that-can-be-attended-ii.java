class Solution {
    public int maxValue(int[][] events, int k) { // Approach 3: Top-down Dynamic Programming + Cached Binary Search
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        nextIndices = new int[n];
        for (int curIndex = 0; curIndex < n; ++curIndex) {
            nextIndices[curIndex] = bisectRight(events, events[curIndex][1]);
        }
        
        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, k, events);
    }    
    
    private int[][] dp;
    private int[] nextIndices;
    private int dfs(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        int nextIndex = nextIndices[curIndex];
        dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }
    
    public static int bisectRight(int[][] events, int target) { 
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}