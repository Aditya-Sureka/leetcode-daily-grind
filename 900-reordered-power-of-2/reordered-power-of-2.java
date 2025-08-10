class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] number = sortedDigits(n); // performing opr based on sorted digits
        for(int i = 0; i < 30; i++) {
            char[] powerOfTwo = sortedDigits(1 << i); // checking if power of 2 or not?
            if(Arrays.equals(number, powerOfTwo)) return true;
        }
        return false;
    }
    private char[] sortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray(); // converting to char array 
        Arrays.sort(digits); // sorting
        return digits;
    }
}