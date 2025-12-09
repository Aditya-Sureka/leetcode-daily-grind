class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];

        for(int i = 0; i < m; i++) {
            ans[i] = nums1[i];
        }

        for(int j = 0; j < n; j++) {
            ans[m + j] = nums2[j];  
        } 

        Arrays.sort(ans);

        int k = ans.length;

        if(k == 1) return ans[0]; 

        double median = 0;

        if(k % 2 == 1) { 
            median = ans[k / 2];  
        } else {
            median = (ans[k/2] + ans[(k/2) - 1]) / 2.0; 
        }

        return median;
    }
}
