class Solution {
    public char kthCharacter(int k) {
        List<Integer> word = new ArrayList<>();
        word.add(0);

        while(word.size() < k) {
            int m = word.size();

            for(int i = 0; i < m; i++) {
                word.add((word.get(i) + 1) % 26);
            }
        }
        return (char)('a' + word.get(k - 1));
    }
}