class Solution {
    public char kthCharacter(long k, int[] operations) {
        long jump = 0, num = k;

        while (num > 1) {
            int lo_range = (int)(Math.log(num) / Math.log(2));
            int hi_range = lo_range + 1;

            long border = 1L << lo_range;

            if (border == num) {
                lo_range--;
                border = 1L << lo_range;
            }

            int ind = lo_range;  // or hi_range - 1
            num -= border;

            if (operations[ind] == 1) {
                jump++;
            }
        }

        return (char)('a' + (int)(jump % 26));
    }
}