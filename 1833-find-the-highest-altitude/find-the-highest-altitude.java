class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitude = new int[n + 1];
        altitude[0] = 0;
        int maxAltitude = 0;

        for (int i = 0; i < n; i++) {
            altitude[i + 1] = altitude[i] + gain[i];  // ✅ Corrected index
            if (altitude[i + 1] > maxAltitude) {
                maxAltitude = altitude[i + 1];
            }
        }

        return maxAltitude;
    }
}
