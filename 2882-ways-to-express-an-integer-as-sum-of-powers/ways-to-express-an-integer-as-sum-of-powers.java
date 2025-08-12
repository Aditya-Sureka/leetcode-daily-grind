class Solution {
    int M = (int)1e9 + 7;
    private int[][] t = new int[301][301];
    public int solve(int n,int num, int x) {
        if(n == 0) return 1; // 1 way found
        if(n < 0) return 0;

        int currPowerValue = (int)Math.pow(num, x);
        if(currPowerValue > n) {
            return 0;
        }
        if(t[n][num] != -1) {
            return t[n][num];
        }
        int take = solve(n - currPowerValue, num + 1, x);
        int skip = solve(n , num + 1, x);
        return t[n][num] = (take + skip) % M;
    }

    public int numberOfWays(int n, int x) {
         for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }
        return solve(n, 1, x); 
    }
}