import java.util.Arrays;

class Solution {

    // returns total hours as long to avoid overflow
    public long calculateTotalHours(int[] piles, int hourly, int h) {
        long totalHours = 0L;
        for (int pile : piles) {
            // ceil division using integers
            totalHours += (pile + hourly - 1) / hourly;
            // early exit if already exceeds h to save work and avoid huge accumulation
            if (totalHours > h) return totalHours;
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxVal;
        int ans = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2; // safer mid
            long totalH = calculateTotalHours(piles, mid, h);

            if (totalH <= (long) h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
