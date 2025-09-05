class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
       for (int t = 1; t <= 36; t++) {
            long val = (long) num1 - (long) t * num2;

            if (val < 0)
                return -1;

            if (Long.bitCount(val) <= t && t <= val) {
                return t;
            }
        }

        return -1;
        
    }
}