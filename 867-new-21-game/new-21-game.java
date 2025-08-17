class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];

        P[0] = 1; // initially score was 0, so probability will be 1

        double result = 0.0;
        double currProbSum = (k == 0) ? 0 : 1;

        for(int i = 1; i <= n; i++) {
           P[i] = currProbSum / maxPts;

           if(i < k) currProbSum += P[i];
            if(i - maxPts >= 0 && i - maxPts < k) {
                currProbSum -= P[i - maxPts];
            }
        }
        for(int pts = k; pts <= n; pts++) {
            result += P[pts];
        }
        return result;
    }
}