class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums[a], nums[b]) // Min-heap based on value at index
        );

        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(i);
            } else if (nums[pq.peek()] < nums[i]) {
                pq.poll();
                pq.offer(i);
            }
        }

        List<Integer> indices = new ArrayList<>();
        while (!pq.isEmpty()) {
            indices.add(pq.poll());
        }

        Collections.sort(indices); // Maintain original order

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[indices.get(i)];
        }

        return ans;
    }
}