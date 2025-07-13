class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int m = players.length;
        int n = trainers.length;
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            }else {
                j++;
            }
        }
   
        return count;
    }
}