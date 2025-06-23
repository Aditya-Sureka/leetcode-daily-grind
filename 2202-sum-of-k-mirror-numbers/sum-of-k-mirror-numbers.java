class Solution {
    // building 1st half (pre) + 2nd half
    private long solve(long pre, int is_odd) {
        long tmp = pre;
        if(is_odd == 1) tmp /= 10;

        while(tmp > 0) {
            pre = pre * 10 + (tmp % 10); // 11 + 3 => 113? // 11*10 + 3 = 113
            tmp /= 10;
        }
        return pre;
    }

     // this will generate all palindrome for a given length
    private List<Long> kthPalindrome(int len) {
        List<Long> ans = new ArrayList<>();

        // 1st half length
        int half = (len + 1) / 2 - 1;
        long mn = 1, mx = 9;
        while (half-- > 0) {
            mn = mn * 10;
            mx = mx * 10 + 9;
        }

        long val = 0;
        while (true) {
            long pos = val;

            long num = mn + pos;
            if (num > mx) break;
            else {
                long complete = solve(num, len % 2);
                ans.add(complete);
            }
            val++;
        }

        return ans;
    }

    private boolean is_palin(long num, int base) {
        // convert to base
        StringBuilder s = new StringBuilder();
        while (num > 0) {
            s.append((char)((num % base) + '0'));
            num /= base;
        }

        // Check if s is a palindrome
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int cnt = 0;

        for (int len = 1; len < 12; len++) {
            List<Long> ele = kthPalindrome(len);

            for (long val : ele) {
                if (is_palin(val, k)) {
                    // cout<<val<<" ";
                    sum += val;
                    cnt++;

                    if (cnt == n) return sum;
                }
            }
        }

        return sum;
    }
}

