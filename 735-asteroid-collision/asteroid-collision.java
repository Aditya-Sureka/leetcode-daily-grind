class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int a : asteroids) {
            boolean alive = true;
            while(!st.isEmpty() && a < 0 && st.peek() > 0) {
                int sum = a + st.peek();

                if(sum < 0) {
                    st.pop();
                } else if(sum > 0) {
                    a = 0;
                } else {
                    st.pop();
                    a = 0;
                }
            }

            if(a != 0) {
                st.push(a);
            }
        }
        int s = st.size();
        int[] result = new int[s];
        int i = s - 1;
        while(!st.isEmpty()) {
            result[i] = st.peek();
            st.pop();
            i--;
        } 
        return result;
    }
}